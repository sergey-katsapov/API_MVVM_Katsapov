package com.example.filmsmvvm.api.data

data class SearchImageListDto(
    val total: Int? = null,
    val totalHits: Int? = null,
    val hits: List<HitDto>? = null
)