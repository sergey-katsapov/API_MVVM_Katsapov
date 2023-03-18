package com.example.filmsmvvm.domain.use_cases

import com.example.filmsmvvm.data.remote.dto.SearchHitsListDto
import com.example.filmsmvvm.domain.repositories.HitsRepository
import javax.inject.Inject

class HitsUseCase @Inject constructor(
    private val hitsRepository: HitsRepository
) {
    suspend fun getSearchHits(query: String): SearchHitsListDto =
        hitsRepository.getSearchHits(query = query)
}