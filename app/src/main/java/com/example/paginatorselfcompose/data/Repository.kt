package com.example.paginatorselfcompose.data

import com.example.paginatorselfcompose.data.model.ListItem
import kotlinx.coroutines.delay

class Repository {

    private val remoteDataSource = (1..100).map {
        ListItem(
            title = "Title #$it",
            description = "description of item $it\nsome information.."
        )
    }

    suspend fun getItems(page: Int, pageSize: Int): Result<List<ListItem>> {
        delay(2000)
        val startingIndex = page * pageSize
        return if (startingIndex + pageSize <= remoteDataSource.size) {
            Result.success(
                remoteDataSource.slice(startingIndex until startingIndex + pageSize)
            )
        } else Result.success(emptyList())
    }

}