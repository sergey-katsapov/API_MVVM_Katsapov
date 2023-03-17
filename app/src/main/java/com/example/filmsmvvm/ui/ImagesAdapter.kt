package com.example.filmsmvvm.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.filmsmvvm.api.data.HitDto
import com.example.filmsmvvm.databinding.ItemImageBinding

class ImagesAdapter : RecyclerView.Adapter<ImagesAdapter.HitHolder>() {

    private val images = mutableListOf<HitDto>()

    class HitHolder(private val itemImageBinding: ItemImageBinding) :
        RecyclerView.ViewHolder(itemImageBinding.root) {
        fun bind(image: HitDto) {
            Glide.with(itemView)
                .load(image.largeImageURL)
                .into(itemImageBinding.image)
        }
    }

    fun setData(images: List<HitDto>) {
        this.images.clear()
        this.images.addAll(images)
        notifyDataSetChanged() //TODO
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HitHolder {
        val itemImageBinding =
            ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HitHolder(itemImageBinding)
    }

    override fun onBindViewHolder(holder: HitHolder, position: Int) {
        val hit = images[position]
        holder.bind(hit)
    }

    override fun getItemCount(): Int = images.size
}