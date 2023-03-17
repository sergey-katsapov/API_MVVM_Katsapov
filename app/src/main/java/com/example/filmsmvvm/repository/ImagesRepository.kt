package com.example.filmsmvvm.repository

import com.example.filmsmvvm.Config
import com.example.filmsmvvm.api.ImagesApi
import javax.inject.Inject

class ImagesRepository @Inject constructor(
    private val imagesApi: ImagesApi
) {

    suspend fun getSearchImages(query: String) = imagesApi.getSearchImages(
        apiKey = Config.PIXABAY_API_KEY,
        query = query
    )
}