package com.example.s1311134006

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.s1311134006.databinding.ActivityPm25Binding
import retrofit2.Call
import retrofit2.Response

class pm25Activity : AppCompatActivity() {
    private val TAG = "LogDemo"
    private lateinit var binding: ActivityPm25Binding
    private lateinit var homeArrow:ImageView
    private var uvList: MutableList<uvData.Records.WeatherElement.Location> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPm25Binding.inflate(layoutInflater)
        setContentView(binding.root)
        homeArrow = binding.Pm25ToHome
        getData()
        homeArrow.setOnClickListener({
            startActivity(Intent(this,MainActivity::class.java))
        })

    }
    private fun getData(){
        uvApi
            .retrofitService
            .getData(Authorization="CWB-F720A7AF-8FFF-4EBB-AFEA-0B3A675FF9CC",format="JSON")
            .enqueue(object:retrofit2.Callback<uvData>{
                override fun onFailure(call: Call<uvData>, t:Throwable){
                    Log.e("fail",t.toString())
                }
                override fun onResponse(
                    call: Call<uvData>,
                    response:Response<uvData>
                ){
                    Log.d(TAG,response.raw().toString())
                    Log.e("saasdasdasd","dsfsdfsd")
                    if(response.isSuccessful){
                        response.body()?.records?.weatherElement?.location?.forEach{
                            Log.d("api",it.toString())
                            if(it.locationCode =="467490"){
                                uvList.add(it)
                                setUVData()
                                setUVString()
                            }
                        }
                    }


                    Log.e(TAG,uvList.toString())
                }

            })

    }
    private fun setUVData(){
        var uvValueText:TextView=findViewById(R.id.uvValue)
        uvValueText.text = uvList[0].value.toString()
    }
    private fun setUVString(){
        var uvText:TextView=findViewById(R.id.uvText)
        when(uvList[0].value){
            in 0.0..2.0 ->{
                uvText.text = "最弱"
                uvText.setTextColor(Color.parseColor("#279500"))
//                uvText.textColors= Color"#279500"
            }
            in 3.0..4.0 ->{
                uvText.text = "弱"
                uvText.setTextColor(Color.parseColor("#f7e400"))
            }
            in 5.0..6.0 ->{
                uvText.text = "中等"
                uvText.setTextColor(Color.parseColor("#f85903"))
            }
            in 7.0..9.0->{
                uvText.text = "強"
                uvText.setTextColor(Color.parseColor("#d8011d"))
            }
            else->{
                uvText.text = "很強"
                uvText.setTextColor(Color.parseColor("#6a49c7"))

            }
        }
    }


}

