package com.sadahacks.mvvm_with_jetpack.network

import com.sadahacks.mvvm_with_jetpack.util.MY_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroBuilder {
    companion object{
        private val retrofit:Retrofit by lazy {
            Retrofit.Builder().baseUrl(MY_URL.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        }
    }

    val api:Api by lazy {
        retrofit.create(Api::class.java)
    }
}