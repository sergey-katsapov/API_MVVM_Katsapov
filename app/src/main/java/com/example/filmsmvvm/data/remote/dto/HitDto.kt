package com.example.filmsmvvm.data.remote.dto

data class HitDto(
    val id: String,
    val largeImageURL: String? = null,
    val imageURL: String? = null,
    val imageWidth: Int? = null,
    val imageHeight: Int? = null
)