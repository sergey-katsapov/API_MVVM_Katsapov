package com.example.filmsmvvm.domain.models

import com.microsoft.azure.storage.Constants.EMPTY_STRING

data class Hit(
    val id: String,
    val largeImageURL: String? = EMPTY_STRING,
    val imageURL: String? = EMPTY_STRING,
    val imageWidth: Int? = 0,
    val imageHeight: Int? = 0
)