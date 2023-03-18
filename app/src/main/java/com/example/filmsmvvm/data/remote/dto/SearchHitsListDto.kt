package com.example.filmsmvvm.data.remote.dto

import com.example.filmsmvvm.domain.models.SearchHitsList
import com.google.gson.annotations.SerializedName

data class SearchHitsListDto(
    @SerializedName("total")
    val total: Int? = null,

    @SerializedName("totalHits")
    val totalHits: Int? = null,

    @SerializedName("hits")
    val hits: List<HitDto>? = null
)

fun SearchHitsListDto.toSearchHitsList() =
    SearchHitsList(
        total = total,
        totalHits = totalHits,
        hits = hits?.map { it.toHit() }
    )