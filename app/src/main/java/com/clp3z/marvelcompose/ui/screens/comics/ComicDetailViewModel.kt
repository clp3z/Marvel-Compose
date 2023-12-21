package com.clp3z.marvelcompose.ui.screens.comics

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import com.clp3z.marvelcompose.repository.ComicsRepository
import com.clp3z.marvelcompose.repository.models.Comic
import com.clp3z.marvelcompose.repository.models.Result
import com.clp3z.marvelcompose.ui.navigation.NavigationArgument
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ComicDetailViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    data class ViewState(
        val isLoading: Boolean = false,
        val comic: Result<Comic?> = Either.Right(null)
    )

    private var _viewState = MutableStateFlow(ViewState())
    val viewState get() = _viewState.asStateFlow()

    private val id = savedStateHandle.get<Int>(NavigationArgument.Id.key)
        ?: throw IllegalStateException("Comic id not found")

    init {
        viewModelScope.launch {
            _viewState.update { ViewState(isLoading = true)  }
            _viewState.update { ViewState(comic = ComicsRepository.getComic(id)) }
        }
    }
}
