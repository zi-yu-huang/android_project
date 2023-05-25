package com.example.s1311134006

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.example.s1311134006.databinding.ActivityMainBinding
import com.example.s1311134006.databinding.ActivitySunRiseBinding

class SunRiseActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySunRiseBinding
    private lateinit var arrow:ImageView
    private lateinit var homeArrow:ImageView
    private lateinit var timeNow:TextView
    private lateinit var sunRiseTime:TextView
    private lateinit var sunSetTime:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySunRiseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        arrow = binding.changeMoon
        homeArrow = binding.SunToHome
        sunRiseTime = binding.sunriseTime
        sunSetTime = binding.sunsetTime
        arrow.setOnClickListener({
            startActivity(Intent(this,moonRiseActivity::class.java))
        })
        homeArrow.setOnClickListener({
            startActivity(Intent(this,MainActivity::class.java))
        })
    }
}