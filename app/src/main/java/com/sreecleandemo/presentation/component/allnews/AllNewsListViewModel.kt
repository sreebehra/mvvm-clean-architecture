package com.sreecleandemo.presentation.component.allnews

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sreecleandemo.common.Resource
import com.sreecleandemo.domain.model.NewsListState
import com.sreecleandemo.domain.usecase.GetAllNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AllNewsListViewModel @Inject constructor(val getAllNewsUseCase: GetAllNewsUseCase) :
    ViewModel() {

    private val _newsList = mutableStateOf(NewsListState())
    val newsList: State<NewsListState> = _newsList

    init {
        getAllNewsList()
    }

    private fun getAllNewsList() {
        getAllNewsUseCase().onEach {
            when (it) {
                is Resource.Loading -> {
                    _newsList.value = NewsListState(isLoading = true)
                }

                is Resource.Success -> {
                    _newsList.value = NewsListState(data = it.data)
                }

                is Resource.Error -> {
                    _newsList.value = NewsListState(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope) //**Keep in mind to launchIn
    }

}