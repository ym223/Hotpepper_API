package com.example.hotpepper_api.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.hotpepper_api.ResultViewModel
import com.example.hotpepper_api.R
import com.example.hotpepper_api.model.Params

class MainActivity : AppCompatActivity() {

    private val viewModel: ResultViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getShopList(Params.KEY, Params.SMALL_AREA, Params.SPECIAL_CATEGORY, Params.TYPE, Params.FORMAT)

        viewModel.shopList.observe(this,
                Observer {
                    Log.d("shopList", viewModel.shopList.value.toString())
                    val text = viewModel.shopList.value?.get(1)
                    findViewById<TextView>(R.id.result).text = text.toString()
                }
        )
    }
}