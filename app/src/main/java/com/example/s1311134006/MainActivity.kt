package com.example.s1311134006

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast
import com.example.s1311134006.databinding.ActivityMainBinding
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var sunRise: FrameLayout
    private lateinit var weather: FrameLayout
    private lateinit var pm25: FrameLayout
    private lateinit var setting: FrameLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sunRise = binding.sunRise
        weather = binding.weather
        pm25 = binding.pm25
        setting = binding.setting
        sunRise.setOnClickListener({
            startActivity(Intent(this,SunRiseActivity::class.java))
        })
        weather.setOnClickListener({
            startActivity(Intent(this,weatherActivity::class.java))
        })
        pm25.setOnClickListener({
            startActivity(Intent(this,pm25Activity::class.java))
        })
        setting.setOnClickListener({
            startActivity(Intent(this,settingActivity::class.java))
        })
    }
    private fun sunRiseIntent(){


    }
//    private fun setupView(){
//        val  queryString = "https://opendata.cwb.gov.tw/api/v1/rest/datastore/A-B0062-001?Authorization=CWB-F720A7AF-8FFF-4EBB-AFEA-0B3A675FF9CC&limit=10&format=JSON&CountyName=%E8%87%BA%E4%B8%AD%E5%B8%82"
////        val client :HttpURLConnection = OkHttpClient()
//        val connection = URL(queryString).openConnection() as HttpURLConnection
//        try {
//            val data = connection.inputStream.bufferedReader().use { it.readText() }
//            Log.d("test",data)
//            // ... do something with "data"
//        } finally {
//            connection.disconnect()
//        }
//    }


}