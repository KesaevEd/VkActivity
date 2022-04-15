package com.example.vkactivity.recViewAdapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vkactivity.R
import com.example.vkactivity.databinding.FotoItemBinding
import com.example.vkactivity.models.FotoItem
import com.example.vkactivity.models.StoriesItem


class FotoAdapter: RecyclerView.Adapter<FotoAdapter.FotoHolder>() {

    val fotoList = ArrayList<FotoItem>()

    class FotoHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = FotoItemBinding.bind(item)
        fun bind(fotoItem: FotoItem) = with(binding){
            imageView.setImageResource(fotoItem.imageId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FotoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.foto_item, parent, false)
        return FotoHolder(view)
    }

    override fun onBindViewHolder(holder: FotoHolder, position: Int) {
        holder.bind(fotoList[position])
    }

    override fun getItemCount(): Int {
        return fotoList.size
    }

    fun addFotoItem(fotoItem: FotoItem){
        fotoList.add(fotoItem)
        notifyDataSetChanged()
    }
}