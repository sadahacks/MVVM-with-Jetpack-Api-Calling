package com.sadahacks.mvvm_with_jetpack.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sadahacks.mvvm_with_jetpack.repository.Repo

class MainViewModelFactory(private val repo: Repo): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        MainViewModel(repo) as T
}