package com.clp3z.marvelcompose.ui.screens.events

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import com.clp3z.marvelcompose.repository.EventsRepository
import com.clp3z.marvelcompose.repository.models.Event
import com.clp3z.marvelcompose.repository.models.Result
import com.clp3z.marvelcompose.ui.navigation.NavigationArgument
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class EventDetailViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    data class ViewState(
        val isLoading: Boolean = false,
        val event: Result<Event?> = Either.Right(null)
    )

    private val _viewState = MutableStateFlow(ViewState())
    val viewState get() = _viewState.asStateFlow()

    private val id = savedStateHandle.get<Int>(NavigationArgument.Id.key)
        ?: throw IllegalStateException("Event id not found")

    init {
        viewModelScope.launch {
            _viewState.update { ViewState(isLoading = true) }
            _viewState.update { ViewState(event = EventsRepository.getEvent(id = id)) }
        }
    }
}
