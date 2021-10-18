package com.example.hotpepper_api

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hotpepper_api.model.Shop

class MyViewModel (application: Application) : AndroidViewModel(application){

    private var _shopList = MutableLiveData<List<Shop>>()
    val shopList: LiveData<List<Shop>> = _shopList
}