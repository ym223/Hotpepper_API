package com.example.hotpepper_api

import com.example.hotpepper_api.model.ResultResponse
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException

class ResultRepository {
    private val retrofit = Retrofit.Builder()
            .baseUrl(HotpepperApi.baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
            .build()

    private val hotPepperService = retrofit.create(HotpepperApi::class.java)

    suspend fun getResultResponse(key: String, small_area: String, format: String): ResultResponse {
        return hotPepperService.getResultResponse(key,small_area, format)
    }
}