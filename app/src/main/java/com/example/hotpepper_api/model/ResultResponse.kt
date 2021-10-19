package com.example.hotpepper_api.model

data class ResultResponse(
    val result: Result
){
    data class Result(
            val api_version: String,
            val results_available: Int,
            val results_returned: String,
            val results_start: Int,
            val shop: List<Shop>
    ){
        data class Shop(
                val access: String,
                val address: String,
                val budget_memo: String?,
                val catch: String,
                val food: Food?,
                val genre: Genre,
                val id: String,
                val lat: Double,
                val lng: Double,
                val name: String,
                val other_memo: String?,
                val photo: Photo,
                val shop_detail_memo: String?,
                val urls: Urls
        ){
            class Food(

            )
            data class Genre(
                    val catch: String,
                    val name: String
                    )
            data class Photo(
                    val pc: Pc
            ){
                data class Pc(
                        val l: String,
                        val m: String,
                        val s: String
                )
            }
            data class Urls(
                    val pc: String
            )
        }
    }
}