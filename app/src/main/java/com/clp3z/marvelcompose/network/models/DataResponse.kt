package com.clp3z.marvelcompose.network.models

import com.google.gson.annotations.SerializedName

data class DataResponse<T>(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    @SerializedName("results") val characters: List<T>
)