package com.clp3z.marvelcompose.ui.screens.comics

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clp3z.marvelcompose.repositories.ComicsRepository
import com.clp3z.marvelcompose.repositories.models.Comic
import kotlinx.coroutines.launch

class ComicsViewModel : ViewModel() {

    data class ViewState(
        val isLoading: Boolean = false,
        val comics: List<Comic> = emptyList()
    )

    var viewState: Map<Comic.Format, MutableState<ViewState>> =
        Comic.Format.values().associate { it to mutableStateOf(ViewState()) }

    fun requestFormat(format: Comic.Format) {
        val viewState = viewState.getValue(format)
        if (viewState.value.comics.isNotEmpty()) return

        viewModelScope.launch {
            viewState.value = ViewState(isLoading = true)
            viewState.value = ViewState(comics = ComicsRepository.getComics(format))
        }
    }
}
