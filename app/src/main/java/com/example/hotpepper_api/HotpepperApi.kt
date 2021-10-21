package com.example.hotpepper_api

import com.example.hotpepper_api.model.ResultResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface HotpepperApi {
    @GET("/")
    suspend fun getResultResponse(@Query("key") key: String,
                                  @Query("small_area") small_area: String,
                                  @Query("format") format: String): Call<ResultResponse>
}