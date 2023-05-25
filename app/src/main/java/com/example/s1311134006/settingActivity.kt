package com.example.s1311134006

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.s1311134006.databinding.ActivitySettingBinding
import com.example.s1311134006.databinding.ActivityWeatherBinding

class settingActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingBinding
    private lateinit var homeArrow: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        homeArrow = binding.SettingToHome
        homeArrow.setOnClickListener({
            startActivity(Intent(this,MainActivity::class.java))
        })    }
}