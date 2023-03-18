package com.example.filmsmvvm.domain.use_cases

import com.example.filmsmvvm.data.remote.dto.toSearchHitsList
import com.example.filmsmvvm.domain.models.SearchHitsList
import com.example.filmsmvvm.domain.repositories.HitsRepository
import javax.inject.Inject

class HitsUseCase @Inject constructor(
    private val hitsRepository: HitsRepository
) {
    suspend fun getSearchHits(query: String): SearchHitsList =
        hitsRepository.getSearchHits(query = query).toSearchHitsList()
}