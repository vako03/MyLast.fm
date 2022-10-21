package com.benten.lastfmapp.presentation.genres

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.benten.lastfmapp.domain.repositories.GenresRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GenresViewModel @Inject constructor(private val genresRepo: GenresRepo) : ViewModel() {
    private val genresStateFlow = MutableStateFlow<UiState>(UiState.Loading)

    val _uiState: StateFlow<UiState> = genresStateFlow

    init {
        viewModelScope.launch {
            genresRepo.getTopGenres("8a0e338471e81bb0dffeaa37600d414b")

                .catch {
                    genresStateFlow.value = UiState.Error(throwable = it)
                }
                .collectLatest { response ->
                    genresStateFlow.value = UiState.Success(data = response)
                }
        }
    }
}