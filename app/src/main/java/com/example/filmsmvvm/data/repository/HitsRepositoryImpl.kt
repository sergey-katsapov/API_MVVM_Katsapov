package com.example.filmsmvvm.data.repository

import com.example.filmsmvvm.data.remote.dto.SearchHitsListDto
import com.example.filmsmvvm.data.repository.remote.HitsRemote
import com.example.filmsmvvm.domain.repositories.HitsRepository
import javax.inject.Inject

class HitsRepositoryImpl @Inject constructor(
    private val hitsRemote: HitsRemote
) : HitsRepository {

    override suspend fun getSearchHits(query: String): SearchHitsListDto =
        hitsRemote.getSearchHits(query = query)
}