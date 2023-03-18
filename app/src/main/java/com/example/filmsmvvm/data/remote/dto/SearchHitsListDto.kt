package com.example.filmsmvvm.data.remote.dto

data class SearchHitsListDto(
    val total: Int? = null,
    val totalHits: Int? = null,
    val hits: List<HitDto>? = null
)