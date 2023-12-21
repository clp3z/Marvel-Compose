package com.clp3z.marvelcompose.ui.screens.comics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import com.clp3z.marvelcompose.repository.ComicsRepository
import com.clp3z.marvelcompose.repository.models.Comic
import com.clp3z.marvelcompose.repository.models.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ComicsViewModel : ViewModel() {

    data class ViewState(
        val isLoading: Boolean = false,
        val comics: Result<List<Comic>> = Either.Right(emptyList())
    )

    private val _viewState = MutableStateFlow(
        Comic.Format.values().associateWith { MutableStateFlow(ViewState()) }
    )
    val viewState get() = _viewState.asStateFlow()

    fun requestFormat(format: Comic.Format) {
        val currentViewState: MutableStateFlow<ViewState> = viewState.value.getValue(format)
        if (currentViewState.value.comics.isRight { it.isNotEmpty() }) return

        viewModelScope.launch {
            currentViewState.update { ViewState(isLoading = true) }
            currentViewState.update { ViewState(comics = ComicsRepository.getComics(format)) }
        }
    }
}
