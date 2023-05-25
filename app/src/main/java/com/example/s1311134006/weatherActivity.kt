package com.example.s1311134006

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.s1311134006.databinding.ActivityWeatherBinding

class weatherActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWeatherBinding
    private lateinit var homeArrow:ImageView
    private lateinit var high:TextView
    private lateinit var low:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)
        homeArrow = binding.WeatherToHome
        high = binding.megathermal
        low = binding.hypothermia
        homeArrow.setOnClickListener({
            startActivity(Intent(this,MainActivity::class.java))
        })
    }
}