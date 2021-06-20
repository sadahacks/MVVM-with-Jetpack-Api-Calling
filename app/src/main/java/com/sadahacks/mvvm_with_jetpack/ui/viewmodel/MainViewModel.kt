package com.sadahacks.mvvm_with_jetpack.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sadahacks.mvvm_with_jetpack.model.ModelClass
import com.sadahacks.mvvm_with_jetpack.repository.Repo
import kotlinx.coroutines.launch

class MainViewModel(private val repo: Repo) : ViewModel() {
    val myResponse: MutableLiveData<List<ModelClass>> = MutableLiveData()
    fun getPost()
    {
        viewModelScope.launch{
            try{
                val response = Repo().getPost()
                myResponse.value = response

            }catch (e:Exception){
                Log.d("main", "getPost: ${e.message}")
            }
        }
    }
}