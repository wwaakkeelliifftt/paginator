package com.example.paginatorselfcompose

interface Paginator<Key, Item> {
    suspend fun loadNextItem()
    fun reset()
}