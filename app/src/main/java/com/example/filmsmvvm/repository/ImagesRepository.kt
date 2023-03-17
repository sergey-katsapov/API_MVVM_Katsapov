package com.example.filmsmvvm.repository

import com.example.filmsmvvm.Config
import com.example.filmsmvvm.api.ImagesApi
import com.example.filmsmvvm.api.data.SearchImageListDto
import javax.inject.Inject

class ImagesRepository @Inject constructor(
    private val imagesApi: ImagesApi
) {

    suspend fun getSearchImages(query: String) : SearchImageListDto = imagesApi.getSearchImages(
        apiKey = Config.PIXABAY_API_KEY,
        query = query
    )
}