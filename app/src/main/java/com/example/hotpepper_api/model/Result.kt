package com.example.hotpepper_api.model

data class Result(
    val api_version: String,
    val results_available: Int,
    val results_returned: String,
    val results_start: Int,
    val shop: List<Shop>
)