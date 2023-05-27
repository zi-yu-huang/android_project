package com.example.s1311134006

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.example.s1311134006.databinding.ActivityWeatherBinding
import retrofit2.Call
import retrofit2.Response
import java.time.LocalDateTime

class weatherActivity : AppCompatActivity() {
    private val TAG = "LogDemo"
    private lateinit var binding: ActivityWeatherBinding
    private lateinit var homeArrow:ImageView
    private lateinit var high:TextView
    private lateinit var low:TextView
    private var weatherList:MutableList<WeatherData.Records.Location.WeatherElement> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
        homeArrow = binding.WeatherToHome
        high = binding.megathermal
        low = binding.hypothermia
        homeArrow.setOnClickListener({
            startActivity(Intent(this,MainActivity::class.java))
        })
    }
    private fun getData(){
        WeatherApi
            .retrofitService
            .getData(Authorization = "CWB-F720A7AF-8FFF-4EBB-AFEA-0B3A675FF9CC", format = "JSON")
            .enqueue(object:retrofit2.Callback<WeatherData> {
                override fun onFailure(call: Call<WeatherData>, t: Throwable) {
                    Log.e("fail", t.toString())
                }

                override fun onResponse(
                    call: Call<WeatherData>,
                    response: Response<WeatherData>
                ) {
                    Log.d(TAG, response.raw().toString())
                    if (response.isSuccessful) {

                        response.body()?.records?.location?.forEach() {
                            Log.d("api", it.toString())
                            if(it.locationName =="臺中市"){
                                it.weatherElement.forEach(){
                                    if(it.elementName == "MinT" || it.elementName == "MaxT"){
                                        weatherList.add(it)

                                    }
                                }
                                getTemperature()
                            }
                        }
                    }
                }
            })
    }
    private fun getTemperature(){
        var minTem:TextView=findViewById(R.id.hypothermia)
        var maxTem:TextView=findViewById(R.id.megathermal)
        weatherList.forEach(){
            if(weatherList[0].elementName == "MinT"){
                minTem.text = weatherList[0].time[0].parameter.parameterName+"℃"
            }
            if(weatherList[1].elementName == "MaxT"){
                maxTem.text = weatherList[1].time[1].parameter.parameterName+"℃"
            }
        }

    }
}