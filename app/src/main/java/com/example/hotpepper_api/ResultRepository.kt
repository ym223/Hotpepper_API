package com.example.hotpepper_api

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ResultRepository {
    fun getRetrofit() = Retrofit.Builder()
            .baseUrl(HotpepperApi.baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
            .build()
            .create(HotpepperApi::class.java)
}