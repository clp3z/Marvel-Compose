package com.clp3z.marvelcompose.ui.screens.comics

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clp3z.marvelcompose.repositories.ComicsRepository
import com.clp3z.marvelcompose.repositories.models.Comic
import com.clp3z.marvelcompose.ui.navigation.NavigationArgument
import kotlinx.coroutines.launch

class ComicDetailViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    data class ViewState(
        val isLoading: Boolean = false,
        val comic: Comic? = null
    )

    var viewState by mutableStateOf(ViewState())
        private set

    private val id = savedStateHandle.get<Int>(NavigationArgument.Id.key)
        ?: throw IllegalStateException("Comic id not found")

    init {
        viewModelScope.launch {
            viewState = ViewState(isLoading = true)
            viewState = ViewState(comic = ComicsRepository.getComic(id))
        }
    }
}
