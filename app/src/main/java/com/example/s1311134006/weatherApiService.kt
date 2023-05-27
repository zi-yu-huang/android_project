package com.example.s1311134006

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface weatherApiService{
    @GET("F-C0032-001")
    fun getData(
        @Query("Authorization") Authorization:String,
        @Query("format")  format:String,
    ):Call<WeatherData>
}
private const val BASE_URL ="https://opendata.cwb.gov.tw/api/v1/rest/datastore/"

object WeatherApi{
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val retrofitService:weatherApiService= retrofit.create(weatherApiService::class.java)
}