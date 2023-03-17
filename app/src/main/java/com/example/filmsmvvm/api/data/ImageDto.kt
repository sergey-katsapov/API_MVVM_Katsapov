package com.example.filmsmvvm.api.data

data class ImageDto(
    val id: String,
    val largeImageURL: String? = null,
    val imageURL: String? = null,
    val imageWidth: Int? = null,
    val imageHeight: Int? = null
)