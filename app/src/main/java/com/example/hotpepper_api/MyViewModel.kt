package com.example.hotpepper_api

import android.app.Application
import androidx.lifecycle.*
import com.example.hotpepper_api.model.ResultResponse
import kotlinx.coroutines.launch

class MyViewModel (application: Application) : AndroidViewModel(application) {

    private val api = ResultRepository(application.applicationContext.getString(R.string.BASE_URL))

    //private var _shopList = MutableLiveData<List<ResultResponse.Result.Shop>>()
    val shopList = MutableLiveData<List<ResultResponse.Result.Shop>>()

    private fun fetchShopList(key: String, small_area: String, format: String) {
        viewModelScope.launch {
            try {
                shopList.value = api.getShopsList(key, small_area, format)
            } catch (e: Exception) {
                e.stackTrace
            }

        }
    }
}