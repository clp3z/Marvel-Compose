package com.clp3z.marvelcompose.ui.screens.characters

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clp3z.marvelcompose.repositories.CharactersRepository
import com.clp3z.marvelcompose.repositories.models.Character
import kotlinx.coroutines.launch

class CharactersViewModel: ViewModel() {

    data class ViewState(
        val isLoading: Boolean = false,
        val characters: List<Character> = emptyList()
    )

    var viewState by mutableStateOf(ViewState())
        private set

    init {
        viewModelScope.launch {
            viewState = ViewState(isLoading = true)
            viewState = ViewState(characters = CharactersRepository.getCharacters())
        }
    }
}