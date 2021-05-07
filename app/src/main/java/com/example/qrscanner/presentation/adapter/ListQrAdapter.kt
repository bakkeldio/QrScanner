package com.example.qrscanner.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.qrscanner.databinding.ItemQrBinding
import com.example.qrscanner.domain.model.QrModel

class ListQrAdapter:  ListAdapter<QrModel,ListQrAdapter.ItemViewHolder>(DiffCallback()) {


    class ItemViewHolder(private val binding: ItemQrBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: QrModel) = with(binding){

            name.text = item.name
            age.text = item.age.toString()
            binding.root.setOnClickListener {

            }
        }
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemQrBinding.inflate(LayoutInflater.from(parent.context))
        return ItemViewHolder(binding)
    }
}

class DiffCallback: DiffUtil.ItemCallback<QrModel>(){
    override fun areItemsTheSame(oldItem: QrModel, newItem: QrModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: QrModel, newItem: QrModel): Boolean {
        return oldItem == newItem
    }

}