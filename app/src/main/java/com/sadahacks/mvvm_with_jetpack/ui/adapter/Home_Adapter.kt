package com.sadahacks.mvvm_with_jetpack.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sadahacks.mvvm_with_jetpack.R
import com.sadahacks.mvvm_with_jetpack.model.ModelClass

class Home_Adapter(
    private var context: Context,
    private var modelList:ArrayList<ModelClass>):
    RecyclerView.Adapter<HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return modelList.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val pos = modelList[position]
        holder.text1.text = pos.id.toString()
        holder.text2.text = pos.body
        holder.text3.text = pos.body
    }
    fun setPostData(postList: ArrayList<ModelClass>)
    {
        this.modelList=postList
        notifyDataSetChanged()
    }
}

class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val text1:TextView = itemView.findViewById(R.id.textView)
    val text2:TextView = itemView.findViewById(R.id.textView2)
    val text3:TextView = itemView.findViewById(R.id.textView3)
}

