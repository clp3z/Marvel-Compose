package com.clp3z.marvelcompose.ui.screens.characters

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import com.clp3z.marvelcompose.repository.CharactersRepository
import com.clp3z.marvelcompose.repository.models.Character
import com.clp3z.marvelcompose.repository.models.Result
import com.clp3z.marvelcompose.ui.navigation.NavigationArgument
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CharacterDetailViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    data class ViewState(
        val isLoading: Boolean = false,
        val character: Result<Character?> = Either.Right(null)
    )

    private val _viewState = MutableStateFlow(ViewState())
    val viewState get() = _viewState.asStateFlow()

    private val id = savedStateHandle.get<Int>(NavigationArgument.Id.key)
        ?: throw IllegalStateException("Character id not found")

    init {
        viewModelScope.launch {
            _viewState.update { ViewState(isLoading = true) }
            _viewState.update { ViewState(character = CharactersRepository.getCharacter(id)) }
        }
    }
}
