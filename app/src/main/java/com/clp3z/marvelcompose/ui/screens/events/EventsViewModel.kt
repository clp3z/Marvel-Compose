package com.clp3z.marvelcompose.ui.screens.events

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clp3z.marvelcompose.repositories.EventsRepository
import com.clp3z.marvelcompose.repositories.models.Event
import kotlinx.coroutines.launch

class EventsViewModel : ViewModel() {

    data class ViewState(
        val isLoading: Boolean = false,
        val events: List<Event> = emptyList()
    )

    var viewState by mutableStateOf(ViewState())
        private set

    init {
        viewModelScope.launch {
            viewState = ViewState(isLoading = true)
            viewState = ViewState(events = EventsRepository.getEvents())
        }
    }
}
