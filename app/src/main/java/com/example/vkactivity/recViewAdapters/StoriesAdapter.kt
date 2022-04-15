package com.example.vkactivity.recViewAdapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vkactivity.R
import com.example.vkactivity.databinding.StoriesItemBinding
import com.example.vkactivity.models.StoriesItem

class StoriesAdapter: RecyclerView.Adapter<StoriesAdapter.StoriesHolder>() {

    val storiesList = ArrayList<StoriesItem>()

    class StoriesHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = StoriesItemBinding.bind(item)
        fun bind(storiesItem: StoriesItem) = with(binding){
            image.setImageResource(storiesItem.imageId)
            textView.text = storiesItem.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.stories_item, parent, false)
        return StoriesHolder(view)
    }

    override fun onBindViewHolder(holder: StoriesHolder, position: Int) {
        holder.bind(storiesList[position])
    }

    override fun getItemCount(): Int {
        return storiesList.size
    }

    fun addStoriesItem(storiesItem: StoriesItem){
        storiesList.add(storiesItem)
        notifyDataSetChanged()
    }
}