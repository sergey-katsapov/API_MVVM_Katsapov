package com.example.filmsmvvm.data.repository.impl

import com.example.filmsmvvm.Config
import com.example.filmsmvvm.data.remote.api.HitsApi
import com.example.filmsmvvm.data.remote.dto.SearchHitsListDto
import com.example.filmsmvvm.data.repository.remote.HitsRemote
import javax.inject.Inject

class HitsRemoteImpl @Inject constructor(
    private val hitsApi: HitsApi
) : HitsRemote {

    override suspend fun getSearchHits(query: String): SearchHitsListDto =
        hitsApi.getSearchHits(
            apiKey = Config.PIXABAY_API_KEY,
            query = query
        )
}