package com.sadahacks.mvvm_with_jetpack.repository

import com.sadahacks.mvvm_with_jetpack.model.ModelClass
import com.sadahacks.mvvm_with_jetpack.network.RetroBuilder

class Repo() {
    suspend fun getPost(): List<ModelClass> = RetroBuilder().api.getAllPost()
}