package com.clp3z.marvelcompose.network.models

import com.google.gson.annotations.SerializedName

data class ServerResponse<T>(
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    @SerializedName("data") val dataResponse: DataResponse<T>,
    val etag: String
)
