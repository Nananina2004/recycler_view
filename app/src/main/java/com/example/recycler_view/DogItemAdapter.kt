package com.example.recycler_view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler_view.databinding.DogItemBinding

class DogItemAdapter(private val context: Context, private val dogItemList: MutableList<DogItem>) :
    RecyclerView.Adapter<DogItemAdapter.DogItemViewHolder>() {

    inner class DogItemViewHolder(private val binding: DogItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(dogItem: DogItem) {
            binding.dogItemName.text = dogItem.name
            binding.dogItemBreed.text = dogItem.breed
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogItemViewHolder {
        val binding = DogItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return DogItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dogItemList.size
    }

    override fun onBindViewHolder(holder: DogItemViewHolder, position: Int) {
        val dogItem = dogItemList[position]
        holder.bind(dogItem)
    }
}
