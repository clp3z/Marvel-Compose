package com.clp3z.marvelcompose.ui.screens.events

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import com.clp3z.marvelcompose.repository.EventsRepository
import com.clp3z.marvelcompose.repository.models.Event
import com.clp3z.marvelcompose.repository.models.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class EventsViewModel : ViewModel() {

    data class ViewState(
        val isLoading: Boolean = false,
        val events: Result<List<Event>> = Either.Right(emptyList())
    )

    private val _viewState = MutableStateFlow(ViewState())
    val viewState get() = _viewState.asStateFlow()

    init {
        viewModelScope.launch {
            _viewState.update { ViewState(isLoading = true) }
            _viewState.update { ViewState(events = EventsRepository.getEvents()) }
        }
    }
}
