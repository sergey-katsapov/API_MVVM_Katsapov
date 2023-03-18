package com.example.filmsmvvm.data.remote.api

import com.example.filmsmvvm.data.remote.dto.SearchHitsListDto
import retrofit2.http.GET
import retrofit2.http.Query

//TODO refactor
interface HitsApi {

    companion object {
        const val GET_HITS_REQUEST = "/api"

        const val KEY_PARAM = "key"
        const val Q_PARAM = "q"
    }

    @GET(GET_HITS_REQUEST)
    suspend fun getSearchHits(
        @Query(KEY_PARAM) apiKey: String,
        @Query(Q_PARAM) query: String
    ): SearchHitsListDto
}