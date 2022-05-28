package com.example.refrigerator_manage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.refrigerator_manage.databinding.FridgeColumnBinding
import com.example.refrigerator_manage.databinding.FridgeDisplayBinding

class OuterFridgeAdapter(val fridgeList: List<FridgeData>) : RecyclerView.Adapter<OuterFridgeAdapter.ViewHolder>(){

    interface OnItemClickListener{
       // fun OnItemClick(data: MyData)
    }

    var itemClickListener: OnItemClickListener ?= null


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val fridgeName = itemView.findViewById<TextView>(R.id.fridgeName)
        val innerFridge = itemView.findViewById<RecyclerView>(R.id.recyclerView)
        init{}
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FridgeColumnBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.fridgeName.text = fridgeList[position].name
        holder.innerFridge.layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.VERTICAL, true)
        holder.innerFridge.adapter = InnerFridgeAdapter(fridgeList[position].floor)
        holder.innerFridge.addItemDecoration(DividerItemDecoration(holder.itemView.context, LinearLayoutManager.VERTICAL))


    }

    override fun getItemCount(): Int {
        return fridgeList.size
    }
}