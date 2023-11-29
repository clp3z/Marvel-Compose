package com.clp3z.marvelcompose.repositories

import com.clp3z.marvelcompose.repositories.models.MarvelItem

abstract class Repository<T : MarvelItem> {

    private var cache: List<T> = emptyList()

    internal suspend fun getItems(getRemoteItems: suspend () -> List<T>): List<T> {
        if (cache.isEmpty()) {
            cache = getRemoteItems()
        }
        return cache
    }

    internal suspend fun getItem(id: Int, getRemoteItem: suspend () -> T): T {
        val item = cache.find { it.id == id }
        if (item != null) return item

        return getRemoteItem()
    }
}