package com.example.hotpepper_api

import com.example.hotpepper_api.model.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface HotpepperApi {
    @GET("gourmet/v1/")
    suspend fun getResultResponse(@Query("key") key: String,
                                  @Query("small_area") small_area: String,
                                  @Query("special_category") special_category: String,
                                  @Query("type") type: String,
                                  @Query("format") format: String): Response
}