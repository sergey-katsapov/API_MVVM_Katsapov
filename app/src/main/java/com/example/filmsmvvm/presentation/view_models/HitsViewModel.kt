package com.example.filmsmvvm.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmsmvvm.Constants.DEFAULT_QUERY
import com.example.filmsmvvm.domain.models.SearchHitsList
import com.example.filmsmvvm.domain.use_cases.HitsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//TODO update add use case
@HiltViewModel
class HitsViewModel @Inject constructor(
    private val hitsUseCase: HitsUseCase
) : ViewModel() {

    private val _hitsList = MutableLiveData<SearchHitsList>()
    val hitsList: LiveData<SearchHitsList> = _hitsList

    init {
        viewModelScope.launch {
            _hitsList.value = hitsUseCase.getSearchHits(query = DEFAULT_QUERY)
        }
    }

    fun search(query: String) {
        viewModelScope.launch {
            _hitsList.value = hitsUseCase.getSearchHits(query = query)
        }
    }
}