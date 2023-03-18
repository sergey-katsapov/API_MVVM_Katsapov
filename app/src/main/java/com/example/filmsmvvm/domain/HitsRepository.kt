package com.example.filmsmvvm.domain

import com.example.filmsmvvm.data.remote.dto.SearchHitsListDto

interface HitsRepository {
    suspend fun getSearchHits(query: String): SearchHitsListDto
}