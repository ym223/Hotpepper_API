package com.example.hotpepper_api

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.hotpepper_api.model.Params
import com.example.hotpepper_api.model.Response
import kotlinx.coroutines.launch


class ResultViewModel : ViewModel() {

    private val repository = ResultRepository(Params.BASE_URL)

    private var _shopList = MutableLiveData<List<Response.Result.Shop>>()
    val shopList: LiveData<List<Response.Result.Shop>> get() = _shopList

    private val _shopNameList: MutableLiveData<List<String>> = MutableLiveData()
    val shopNameList: LiveData<List<String>> get() = _shopNameList

    fun getShopList(key: String, small_area: String, special_category: String, type: String, format: String) {
        viewModelScope.launch {
            try {
                //Log.d("tag", repository.getResponse(key, small_area, special_category, type, format).results.shop.toString())
                _shopList.value = repository.getResponse(key, small_area, special_category, type, format).results.shop
                Log.d("shopList", shopList.value.toString())
            } catch (e: Exception) {
                e.stackTrace
            }
        }
    }

//    fun getShopNameList(key: String, small_area: String, special_category: String, type: String, format: String) {
//        viewModelScope.launch {
//            val shopNameList = arrayListOf<String>()
//            shopList.value?.let {
//                for (i in 0..shopList.value!!.size) {
//                    shopNameList.add(repository.getResponse(key, small_area, special_category, type, format).results.shop[i].name)
//                    Log.d("shopNameList", shopNameList[i])
//                }
//            }
//            _shopNameList.postValue(shopNameList)
//        }
//    }
}