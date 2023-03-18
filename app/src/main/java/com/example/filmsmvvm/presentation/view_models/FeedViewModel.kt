package com.example.filmsmvvm.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmsmvvm.data.remote.dto.SearchHitsListDto
import com.example.filmsmvvm.domain.use_cases.HitsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//TODO update add use case
@HiltViewModel
class FeedViewModel @Inject constructor(
    private val hitsUseCase: HitsUseCase
) : ViewModel() {

    private val _response = MutableLiveData<SearchHitsListDto>()
    val response: LiveData<SearchHitsListDto> = _response

    init {
        viewModelScope.launch {
            _response.value = hitsUseCase.getSearchHits(query = "android")
        }
    }

    fun search(query: String) {
        viewModelScope.launch {
            _response.value = hitsUseCase.getSearchHits(query = query)
        }
    }
}