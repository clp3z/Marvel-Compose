package com.clp3z.marvelcompose.repository

import com.clp3z.marvelcompose.repository.models.MarvelItem
import com.clp3z.marvelcompose.repository.models.Result
import com.clp3z.marvelcompose.repository.models.tryCall
import kotlinx.coroutines.withTimeout

abstract class Repository<T : MarvelItem> {

    private var cache: List<T> = emptyList()

    internal suspend fun getItems(getRemoteItems: suspend () -> List<T>): Result<List<T>> =
        tryCall {
            if (cache.isEmpty()) {
                withTimeout(10000) {
                    cache = getRemoteItems()
                }
            }
            cache
        }

    internal suspend fun getItem(id: Int, getRemoteItem: suspend () -> T): Result<T> = tryCall {
        val item = cache.find { it.id == id }
        item ?: getRemoteItem()
    }
}
