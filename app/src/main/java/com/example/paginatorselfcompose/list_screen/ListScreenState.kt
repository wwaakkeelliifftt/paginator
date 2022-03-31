package com.example.paginatorselfcompose.list_screen

import com.example.paginatorselfcompose.data.model.ListItem

data class ListScreenState(
    val isLoading: Boolean = false,
    val items: List<ListItem> = emptyList(),
    val error: String? = null,
    val endReached: Boolean = false,
    val page: Int = 0
)
