package com.example.paginatorselfcompose.list_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.paginatorselfcompose.DefaultPaginator
import com.example.paginatorselfcompose.data.Repository
import com.example.paginatorselfcompose.data.model.ListItem
import kotlinx.coroutines.launch

class ListScreenViewModel(): ViewModel() {

    private val repository: Repository = Repository()
    var state by mutableStateOf(ListScreenState())

    private val paginator = DefaultPaginator(
        initialKey = state.page,
        onLoadUpdated = {
            state = state.copy(isLoading = it)
        },
        onRequest = { nextPage ->
            repository.getItems(page = nextPage, pageSize = 20)
        },
        getNextKey = {
            state.page + 1
        },
        onError = { throwable ->
            state = state.copy(error = throwable?.localizedMessage)
        },
        onSuccess = { items, newKey ->
            state = state.copy(
                items = state.items + items,
                page = newKey,
                endReached = items.isEmpty()
            )
        }
    )

    init {
        loadNextItems()
    }

    fun loadNextItems() {
        viewModelScope.launch {
            paginator.loadNextItem()
        }
    }





}