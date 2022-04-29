package com.example.handtravel


import android.widget.ListView



import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.handtravel.databinding.ActivityMainBinding
import com.example.handtravel.databinding.ActivityMainBinding.*
import org.json.JSONArray

import android.volley.Request

import android.volley.RequestQueue

import android.volley.Response

import android.volley.VolleyError

import android.volley.toolbox.JsonArrayRequest

import android.volley.toolbox.Volley

import org.json.JSONException

import org.json.JSONObject


import java.lang.reflect.Array

import java.lang.reflect.Method

import java.util.ArrayList


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
           val intent = Intent(this, Loginn::class.java)
            startActivity(intent)
        }
        binding.btn2.setOnClickListener {
            onDestroy()
        }
        GetData()

    }
    private fun GetData(url: String) {
        val requestQueue: Response = Volley.newRequestQueue(this)
        val jsonArrayRequest =
            JsonArrayRequest(Request.Method.GET, url, null, object : Listener<JSONArray?>() {
                fun onResponse(response: JSONArray) {
                    for (i in 0 until response.length()) {
                        try {
                            val `object` = response.getJSONObject(i)
                            arraysinhvien.add(
                                Sinhvien(
                                    `object`.getInt("Id"),
                                    `object`.getString("Hoten"),
                                    `object`.getInt("Namsinh"),
                                    `object`.getString("Diachi"),
                                    `object`.getString("Username"),
                                    `object`.getString("Password")
                                )
                            )
                        } catch (e: Exception) {
                            Log.d("ccc", e.toString())
                            //                        e.printStackTrace();
                        }
                    }
                    adapter.notifyDataSetChanged()
                }
            },
                object : ErrorListener() {
                    fun onErrorResponse(error: VolleyError) {
                        Log.d("BBB", error.toString())
                        Toast.makeText(this@MainActivity, error.toString(), Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            )
        requestQueue.add(jsonArrayRequest)
    }
}
