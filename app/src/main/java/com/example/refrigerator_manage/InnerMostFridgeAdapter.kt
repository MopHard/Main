package com.example.refrigerator_manage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.refrigerator_manage.databinding.FridgeRowBinding
import com.example.refrigerator_manage.databinding.InnerfridgeRowBinding

class InnerMostFridgeAdapter(val fridgeFloor : Int) : RecyclerView.Adapter<InnerMostFridgeAdapter.ViewHolder>(){
    interface OnItemClickListener{
        // fun OnItemClick(data: MyData)
    }

    var itemClickListener: OnItemClickListener ?= null


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        init{}
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = InnerfridgeRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 6
    }
}