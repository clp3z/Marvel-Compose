package com.clp3z.marvelcompose.ui.screens.events

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clp3z.marvelcompose.repositories.EventsRepository
import com.clp3z.marvelcompose.repositories.models.Event
import com.clp3z.marvelcompose.ui.navigation.NavigationArgument
import kotlinx.coroutines.launch

class EventDetailViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    data class ViewState(
        val isLoading: Boolean = false,
        val event: Event? = null
    )

    var viewState by mutableStateOf(ViewState())
        private set

    private val id = savedStateHandle.get<Int>(NavigationArgument.Id.key)
        ?: throw IllegalStateException("Event id not found")

    init {
        viewModelScope.launch {
            viewState = ViewState(isLoading = true)
            viewState = ViewState(event = EventsRepository.getEvent(id = id))
        }
    }
}