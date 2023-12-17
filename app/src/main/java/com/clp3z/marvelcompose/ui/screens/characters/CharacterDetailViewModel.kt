package com.clp3z.marvelcompose.ui.screens.characters

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clp3z.marvelcompose.repositories.CharactersRepository
import com.clp3z.marvelcompose.repositories.models.Character
import com.clp3z.marvelcompose.ui.navigation.NavigationArgument
import kotlinx.coroutines.launch

class CharacterDetailViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    data class ViewState(
        val isLoading: Boolean = false,
        val character: Character? = null
    )

    var viewState by mutableStateOf(ViewState())
        private set

    private val id = savedStateHandle.get<Int>(NavigationArgument.Id.key)
        ?: throw IllegalStateException("Character id not found")

    init {
        viewModelScope.launch {
            viewState = ViewState(isLoading = true)
            viewState = ViewState(character = CharactersRepository.getCharacter(id))
        }
    }
}
