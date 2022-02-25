package com.example.handtravel


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.handtravel.databinding.ActivityRegisterBinding

class Register :AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}