package com.example.hotpepper_api

import com.example.hotpepper_api.model.response.ResultResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HotpepperApi {
    companion object {
        const val baseUrl = "http://webservice.recruit.co.jp/hotpepper/gourmet/v1"
    }
    @GET("/")
    fun getResult(@Query("key") key: String, @Query("small_area") small_area: String, @Query("format") format: String): Call<ResultResponse>
}