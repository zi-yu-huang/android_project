package com.example.s1311134006

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.example.s1311134006.databinding.ActivityMoonRiseBinding
import retrofit2.Call
import retrofit2.Response
import java.time.LocalDateTime

class moonRiseActivity : AppCompatActivity() {
    private val TAG = "LogDemo"
    private lateinit var binding: ActivityMoonRiseBinding
    private lateinit var arrow:ImageView
    private lateinit var moonRise:TextView
    private lateinit var moonSet:TextView
    private var moonriseList: MutableList<MoonRiseData.Locations.Location.Time> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMoonRiseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
        arrow=binding.changeSun
        moonRise = binding.moonriseTime
        moonSet = binding.moonsetTime
        arrow.setOnClickListener({
            startActivity(Intent(this,SunRiseActivity::class.java))
        })
    }
    private fun getData() {
        val currentDateTime = LocalDateTime.now()
        MoonRiseApi
            .retrofitService
            .getData(Authorization = "CWB-F720A7AF-8FFF-4EBB-AFEA-0B3A675FF9CC", format = "JSON")
            .enqueue(object : retrofit2.Callback<MoonRiseData> {
                override fun onFailure(call: Call<MoonRiseData>, t: Throwable) {
                    Log.e("fail", t.toString())
                }

                override fun onResponse(
                    call: Call<MoonRiseData>,
                    response: Response<MoonRiseData>
                ) {
                    Log.d(TAG, response.raw().toString())
                    if (response.isSuccessful) {

                        response.body()?.records?.locations?.location?.forEach {
//                            Log.d("api", it.toString())
                            if (it.CountyName == "臺中市") {
                                it.time.forEach { element ->
                                    val currentDateTimeString =
                                        currentDateTime.toString().split("T")[0]
                                    if (element.Date == currentDateTimeString) {
                                        moonriseList.add(element)
                                        setMoonText()
                                    }

                                }
                            }

                        }
                    }


                    Log.e(TAG, moonriseList.toString())
                }
            })
    }
    private fun setMoonText(){
        var sunriseTime:TextView=findViewById(R.id.moonriseTime)
        var sunsetTime:TextView=findViewById(R.id.moonsetTime)
        sunriseTime.text = moonriseList[0].MoonRiseTime
        sunsetTime.text = moonriseList[0].MoonSetTime
    }
}