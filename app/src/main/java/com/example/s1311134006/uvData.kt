package com.example.s1311134006


data class uvData(
    val records: Records,
    val result: Result,
    val success: String
){
    data class Records(
        val weatherElement: WeatherElement
    ){
        data class WeatherElement(
            val elementName: String,
            val location: List<Location>,
            val time: Time
        ){
            data class Location(
                val locationCode: String,
                val value: Double
            )
            data class Time(
                val dataTime: String
            )
        }
    }
    data class Result(
        val fields: List<Field>,
        val resource_id: String
    ){
        data class Field(
            val id: String,
            val type: String
        )
    }
}