package com.example.hotpepper_api

import android.util.Log
import com.example.hotpepper_api.model.Response
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException

class ResultRepository(baseURL: String) {
    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    private val hotPepperService = retrofit.create(HotpepperApi::class.java)

    suspend fun getResponse(key: String, small_area: String, special_category: String, type: String, format: String): Response{
        return hotPepperService.getResultResponse(key, small_area, special_category, type, format)
//        var shopList: List<Response.Result.Shop> = listOf()
//        withContext(IO) {
//            try {
//                val response = hotPepperService.getResultResponse(key, small_area, special_category, type, format).execute().body()
//                if (response != null) {
//                    shopList = response.result.shop
//                }
//            } catch (e: IOException) {
//                e.printStackTrace()
//            }
//        }
//        return shopList
    }
}