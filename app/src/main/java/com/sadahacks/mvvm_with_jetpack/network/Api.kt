package com.sadahacks.mvvm_with_jetpack.network

import com.sadahacks.mvvm_with_jetpack.model.ModelClass
import com.sadahacks.mvvm_with_jetpack.util.MY_URL
import retrofit2.http.GET

interface Api {

    @GET(MY_URL.URL_END)
    suspend fun getAllPost(): List<ModelClass>

}