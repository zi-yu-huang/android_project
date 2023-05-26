package com.example.s1311134006

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.example.s1311134006.databinding.ActivityMainBinding
import com.example.s1311134006.databinding.ActivitySunRiseBinding
import retrofit2.Call
import retrofit2.Response
import java.time.LocalDateTime
class SunRiseActivity : AppCompatActivity() {
    private val TAG = "LogDemo"
    private lateinit var binding:ActivitySunRiseBinding
    private lateinit var arrow:ImageView
    private lateinit var homeArrow:ImageView
    private lateinit var sunRiseTime:TextView
    private lateinit var sunSetTime:TextView
    private var sunriseList: MutableList<sunriseData.Records.Locations.Location.Time> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySunRiseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
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
    private fun getData(){
        val currentDateTime = LocalDateTime.now()
        sunriseApi
            .retrofitService
            .getData(Authorization="CWB-F720A7AF-8FFF-4EBB-AFEA-0B3A675FF9CC",format="JSON")
            .enqueue(object:retrofit2.Callback<sunriseData>{
                override fun onFailure(call: Call<sunriseData>, t:Throwable){
                    Log.e("fail",t.toString())
                }
                override fun onResponse(
                    call: Call<sunriseData>,
                    response: Response<sunriseData>
                ) {
                    Log.d(TAG, response.raw().toString())
                    Log.e("saasdasdasd", "dsfsdfsd")
                    if (response.isSuccessful) {
//                        Log.d(TAG,response.body()?.success.toString())
//                        Log.d(TAG,response.body()?.records.toString())
//                        Log.d(TAG,response.body()?.result.toString())
                        response.body()?.records?.locations?.location?.forEach {
                            Log.d("api", it.toString())
                            if (it.CountyName == "臺中市") {
                                Log.d(TAG,"jkj")
//                                sunriseList.add(it)
//                                setUVData()
//                                setUVString()
                            }
                        }
                    }


//                    Log.e(TAG,sunriseList.toString())
                }
            })
    }
}