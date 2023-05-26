package com.example.s1311134006

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface sunriseApiService {
    @GET("A-B0062-001")
    fun getData(
        @Query("Authorization") Authorization:String,
        @Query("format")  format:String,
    ):Call<sunriseData>
}

private const val BASE_URL ="https://opendata.cwb.gov.tw/api/v1/rest/datastore/"

object sunriseApi{

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val retrofitService:sunriseApiService= retrofit.create(sunriseApiService::class.java)
}