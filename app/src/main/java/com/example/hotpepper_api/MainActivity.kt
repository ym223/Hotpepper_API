package com.example.hotpepper_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private val viewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val handler = Handler()

        thread {
            try {
                viewModel.getShopList("00f739ce3ffe72d1", "X935", "SPD8", "lite", "json")

                val text = viewModel.shopList.value?.get(0)?.toString()

                handler.post(Runnable {
                    findViewById<TextView>(R.id.result).text = text
                })

            } catch (e: Exception) {
                Log.w("retrofit", "fetchReposList :$e")
            }


        }
    }
}