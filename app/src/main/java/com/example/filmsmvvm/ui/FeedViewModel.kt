package com.example.filmsmvvm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmsmvvm.api.data.SearchImageListDto
import com.example.filmsmvvm.repository.ImagesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//TODO update add use case
@HiltViewModel
class FeedViewModel @Inject constructor(
    private val repository: ImagesRepository
) : ViewModel() {

    private val _response = MutableLiveData<SearchImageListDto>()
    val response: LiveData<SearchImageListDto> = _response

    fun search(query: String) {
        viewModelScope.launch {
            _response.value = repository.getSearchImages(query = query)
        }
    }
}