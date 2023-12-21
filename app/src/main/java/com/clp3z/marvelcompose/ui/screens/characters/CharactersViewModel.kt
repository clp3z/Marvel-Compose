package com.clp3z.marvelcompose.ui.screens.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import com.clp3z.marvelcompose.repository.CharactersRepository
import com.clp3z.marvelcompose.repository.models.Character
import com.clp3z.marvelcompose.repository.models.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CharactersViewModel: ViewModel() {

    data class ViewState(
        val isLoading: Boolean = false,
        val characters: Result<List<Character>> = Either.Right(emptyList())
    )

    private val _viewState = MutableStateFlow(ViewState())
    val viewState get() = _viewState.asStateFlow()

    init {
        viewModelScope.launch {
            _viewState.update { ViewState(isLoading = true) }
            _viewState.update { ViewState(characters = CharactersRepository.getCharacters()) }
        }
    }
}
