package com.example.hotpepper_api

import com.example.hotpepper_api.model.ResultResponse
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException

class ResultRepository(baseURL: String) {
    private val retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
            .build()

    private val hotPepperService = retrofit.create(HotpepperApi::class.java)

    suspend fun getShopsList(key: String, small_area: String, format: String): List<ResultResponse.Result.Shop> {
        var shopList: List<ResultResponse.Result.Shop> = listOf()
        withContext(Dispatchers.IO) {
            try {
                val response = hotPepperService.getResultResponse(key, small_area, format).execute().body()
                if (response != null) {
                    shopList = response.result.shop
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        return shopList
    }


}