package com.sadahacks.mvvm_with_jetpack.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sadahacks.mvvm_with_jetpack.R
import com.sadahacks.mvvm_with_jetpack.databinding.MainDataBinding
import com.sadahacks.mvvm_with_jetpack.model.ModelClass
import com.sadahacks.mvvm_with_jetpack.repository.Repo
import com.sadahacks.mvvm_with_jetpack.ui.adapter.Home_Adapter
import com.sadahacks.mvvm_with_jetpack.ui.viewmodel.MainViewModel
import com.sadahacks.mvvm_with_jetpack.ui.viewmodel.MainViewModelFactory
import java.util.*


class MainActivity : AppCompatActivity() {

    lateinit var binding: MainDataBinding
    lateinit var homeAdapter:Home_Adapter
    private lateinit var repo: Repo
    private lateinit var mainViewModelFactory: MainViewModelFactory
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
//        binding.progressBar.visibility = View.GONE
        initRecyclerView()
        repo= Repo()
        mainViewModelFactory= MainViewModelFactory(repo)
        mainViewModel= ViewModelProvider(this,mainViewModelFactory).get(MainViewModel::class.java)

        binding.button.setOnClickListener{
            mainViewModel.getPost()
            binding.progressBar.visibility = View.VISIBLE
            mainViewModel.myResponse.observe(this, Observer {
                homeAdapter.setPostData(it as ArrayList<ModelClass>)
                Log.d("main", it[0].title)
                binding.progressBar.visibility= View.GONE
                binding.recyclerView2.visibility=View.VISIBLE
            })
        }
    }
    private fun initRecyclerView() {
        homeAdapter= Home_Adapter(this, ArrayList())
        binding.recyclerView2.apply {
            setHasFixedSize(true)
            layoutManager=LinearLayoutManager(this@MainActivity)
            adapter=homeAdapter
        }
    }
}