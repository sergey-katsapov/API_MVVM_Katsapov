package com.example.filmsmvvm.domain

import com.example.filmsmvvm.data.remote.dto.SearchHitsListDto
import javax.inject.Inject

class HitsUseCase @Inject constructor(
    private val hitsRepository: HitsRepository
) {
    suspend fun getSearchHits(query: String): SearchHitsListDto =
        hitsRepository.getSearchHits(query = query)
}