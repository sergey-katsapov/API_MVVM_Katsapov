package com.example.filmsmvvm.presentation.fragments.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.filmsmvvm.databinding.ItemImageBinding
import com.example.filmsmvvm.domain.models.Hit

class HitsAdapter : RecyclerView.Adapter<HitsAdapter.HitHolder>() {

    private val images = mutableListOf<Hit>()

    class HitHolder(private val itemImageBinding: ItemImageBinding) :
        RecyclerView.ViewHolder(itemImageBinding.root) {
        fun bind(image: Hit) {
            Glide.with(itemView)
                .load(image.largeImageURL)
                .into(itemImageBinding.image)
        }
    }

    fun setData(images: List<Hit>) {
        this.images.clear()
        this.images.addAll(images)
        notifyDataSetChanged() //TODO
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HitHolder =
        HitHolder(ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: HitHolder, position: Int) =
        holder.bind(images[position])

    override fun getItemCount() = images.size
}