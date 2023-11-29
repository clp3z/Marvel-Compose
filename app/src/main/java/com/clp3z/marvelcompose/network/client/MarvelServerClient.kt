package com.clp3z.marvelcompose.network.client

import com.clp3z.marvelcompose.network.services.CharactersService
import com.clp3z.marvelcompose.network.services.ComicsService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val API_ENDPOINT = "https://gateway.marvel.com"

object MarvelServerClient {

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor(QueryInterceptor())
        .build()

    private val retrofitAdapter = Retrofit.Builder()
        .baseUrl(API_ENDPOINT)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    val charactersService: CharactersService = retrofitAdapter.create(CharactersService::class.java)
    val comicsService: ComicsService = retrofitAdapter.create(ComicsService::class.java)
}