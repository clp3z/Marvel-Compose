package com.clp3z.marvelcompose.network.models

data class ServerResponse<T>(
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val data: DataResponse<T>,
    val etag: String
)
