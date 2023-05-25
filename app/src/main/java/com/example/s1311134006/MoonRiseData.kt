package com.example.s1311134006

//data class MoonRiseData (
//    val success: String,
//    val result: Result,
//    val records: Records,
//){
//    data class Result(
//        @JsonProperty("resource_id")
//        val resourceId: String,
//        val fields: List<Field>,
//    ){
//        data class Field(
//            val id: String,
//            val type: String,
//        )
//    }
//    data class Records(
//        val dataid: String,
//        val note: String,
//        val locations: Locations,
//    )
//    data class Locations(
//        val location: List<Location>,
//    ){
//        data class Location(
//            val time: List<Time>,
//            @JsonProperty("CountyName")
//            val countyName: String,
//        ){
//            data class Time(
//                @JsonProperty("Date")
//                val date: String,
//                @JsonProperty("BeginCivilTwilightTime")
//                val beginCivilTwilightTime: String,
//                @JsonProperty("SunRiseTime")
//                val sunRiseTime: String,
//                @JsonProperty("SunRiseAZ")
//                val sunRiseAz: String,
//                @JsonProperty("SunTransitTime")
//                val sunTransitTime: String,
//                @JsonProperty("SunTransitAlt")
//                val sunTransitAlt: String,
//                @JsonProperty("SunSetTime")
//                val sunSetTime: String,
//                @JsonProperty("SunSetAZ")
//                val sunSetAz: String,
//                @JsonProperty("EndCivilTwilightTime")
//                val endCivilTwilightTime: String,
//            )
//
//        }
//    }
//}