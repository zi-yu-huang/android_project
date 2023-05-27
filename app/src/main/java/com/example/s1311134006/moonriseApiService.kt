package com.example.s1311134006

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface moonriseApiService{
    @GET("A-B0063-001")
    fun getData(
        @Query("Authorization") Authorization:String,
        @Query("format")  format:String,
    ):Call<MoonRiseData>
}

private const val BASE_URL ="https://opendata.cwb.gov.tw/api/v1/rest/datastore/"
object MoonRiseApi{
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val retrofitService:moonriseApiService= retrofit.create(moonriseApiService::class.java)
}