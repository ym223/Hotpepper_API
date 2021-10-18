package com.example.hotpepper_api.model

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
)