package com.example.s1311134006
import com.fasterxml.jackson.annotation.JsonProperty

class MoonRiseData (
    val success: String,
    val result: Result,
    val records: Records,
){
    data class Result(
        @JsonProperty("resource_id")
        val resource_id: String,
        val fields: List<Field>,
    ){
        data class Field(
            val id: String,
            val type: String,
        )
    }
    data class Records(
        val dataid: String,
        val note: String,
        val locations: Locations,
    )
    data class Locations(
        val location: List<Location>,
    ){
        data class Location(
            val time: List<Time>,
            @JsonProperty("CountyName")
            val CountyName: String,
        ){
            data class Time(
                @JsonProperty("Date")
                val Date: String,
                @JsonProperty("BeginCivilTwilightTime")
                val BeginCivilTwilightTime: String,
                @JsonProperty("SunRiseTime")
                val SunRiseTime: String,
                @JsonProperty("SunRiseAZ")
                val SunRiseAZ: String,
                @JsonProperty("SunTransitTime")
                val SunTransitTime: String,
                @JsonProperty("SunTransitAlt")
                val SunTransitAlt: String,
                @JsonProperty("SunSetTime")
                val SunSetTime: String,
                @JsonProperty("SunSetAZ")
                val SunSetAZ: String,
                @JsonProperty("EndCivilTwilightTime")
                val EndCivilTwilightTime: String,
            )

        }
    }
}