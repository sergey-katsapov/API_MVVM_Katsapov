package com.example.filmsmvvm.data.repository.remote

import com.example.filmsmvvm.data.remote.dto.SearchHitsListDto

interface HitsRemote {
    suspend fun getSearchHits(query: String): SearchHitsListDto
}