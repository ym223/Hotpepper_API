package com.example.hotpepper_api.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Response(
    val results: Result
){
    @JsonClass(generateAdapter = true)
    data class Result(
            val api_version: String,
            val results_available: Int,
            val results_returned: String,
            val results_start: Int,
            val shop: List<Shop>
    ){
        @JsonClass(generateAdapter = true)
        data class Shop(
                val access: String?,
                val address: String?,
                val budget_memo: String?,
                val catch: String?,
                val genre: Genre?,
                val id: String?,
                val lat: Double?,
                val lng: Double?,
                val name: String?,
                val other_memo: String?,
                val photo: Photo?,
                val shop_detail_memo: String?,
                val urls: Urls?
        ){
            @JsonClass(generateAdapter = true)
            data class Genre(
                    val catch: String?,
                    val name: String?
                    )
            @JsonClass(generateAdapter = true)
            data class Photo(
                    val pc: Pc?
            ){
                @JsonClass(generateAdapter = true)
                data class Pc(
                        val l: String?,
                        val m: String?,
                        val s: String?
                )
            }
            @JsonClass(generateAdapter = true)
            data class Urls(
                    val pc: String?
            )
        }
    }
}