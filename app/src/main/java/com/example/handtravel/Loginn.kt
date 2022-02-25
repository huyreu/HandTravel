package com.example.handtravel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.handtravel.databinding.ActivityLoginnBinding

class Loginn : AppCompatActivity() {
    private lateinit var binding: ActivityLoginnBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginnBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.register.setOnClickListener {
            val intent  = Intent(this, Register::class.java)
            startActivity(intent)
        }

    }
}