package com.example.hotpepper_api

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.hotpepper_api.model.Response
import kotlinx.coroutines.launch


class MyViewModel() : ViewModel() {

    private val repository = ResultRepository("http://webservice.recruit.co.jp/hotpepper/")

    //private var _shopList = MutableLiveData<List<ResultResponse.Result.Shop>>()
    val shopList = MutableLiveData<List<Response.Result.Shop>>()

    fun getShopList(key: String, small_area: String, special_category: String, type: String, format: String) {
        viewModelScope.launch {
            val response = repository.getResponse(key, small_area, special_category, type, format)
            Log.d("tag", response.toString())
            //shopList.value = response.result.shop
        }
    }
}