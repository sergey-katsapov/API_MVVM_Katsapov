package com.example.filmsmvvm.data.remote.dto

import com.example.filmsmvvm.domain.models.Hit
import com.google.gson.annotations.SerializedName

data class HitDto(
    @SerializedName("id")
    val id: String,

    @SerializedName("largeImageURL")
    val largeImageURL: String? = null,

    @SerializedName("imageURL")
    val imageURL: String? = null,

    @SerializedName("imageWidth")
    val imageWidth: Int? = null,

    @SerializedName("imageHeight")
    val imageHeight: Int? = null
)

fun HitDto.toHit() =
    Hit(
        id = id,
        largeImageURL = largeImageURL,
        imageURL = imageURL,
        imageWidth = imageWidth,
        imageHeight = imageHeight
    )