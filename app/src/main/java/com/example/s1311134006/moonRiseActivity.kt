package com.example.s1311134006

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.s1311134006.databinding.ActivityMoonRiseBinding

class moonRiseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMoonRiseBinding
    private lateinit var arrow:ImageView
    private lateinit var timeNow:TextView
    private lateinit var moonRise:TextView
    private lateinit var moonSet:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMoonRiseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        arrow=binding.changeSun
        moonRise = binding.moonriseTime
        moonSet = binding.moonsetTime
        arrow.setOnClickListener({
            startActivity(Intent(this,SunRiseActivity::class.java))
        })
    }
}