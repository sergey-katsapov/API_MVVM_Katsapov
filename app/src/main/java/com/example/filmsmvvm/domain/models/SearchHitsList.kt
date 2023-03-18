package com.example.filmsmvvm.domain.models

data class SearchHitsList(
    val total: Int? = 0,
    val totalHits: Int? = 0,
    val hits: List<Hit>? = emptyList()
)