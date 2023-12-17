package com.clp3z.marvelcompose.ui.screens.comics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clp3z.marvelcompose.repositories.ComicsRepository
import com.clp3z.marvelcompose.repositories.models.Comic
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ComicsViewModel : ViewModel() {

    data class ViewState(
        val isLoading: Boolean = false,
        val comics: List<Comic> = emptyList()
    )

    private val _viewState = MutableStateFlow(
        Comic.Format.values().associateWith { MutableStateFlow(ViewState()) }
    )
    val viewState get() = _viewState.asStateFlow()

    fun requestFormat(format: Comic.Format) {
        val currentViewState: MutableStateFlow<ViewState> = viewState.value.getValue(format)
        if (currentViewState.value.comics.isNotEmpty()) return

        viewModelScope.launch {
            currentViewState.update { ViewState(isLoading = true) }
            currentViewState.update { ViewState(comics = ComicsRepository.getComics(format)) }
        }
    }
}
