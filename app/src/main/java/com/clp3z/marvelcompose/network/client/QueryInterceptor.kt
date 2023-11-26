package com.clp3z.marvelcompose.network.client

import com.clp3z.marvelcompose.BuildConfig
import com.clp3z.marvelcompose.common.generateHash
import okhttp3.Interceptor
import okhttp3.Response
import java.util.Date

class QueryInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalUrl= original.url

        val timeStamp = Date().time
        val hash = generateHash(timeStamp, BuildConfig.MARVEL_PRIVATE_KEY, BuildConfig.MARVEL_PUBLIC_KEY)

        val url = originalUrl.newBuilder()
            .addQueryParameter("apikey", BuildConfig.MARVEL_PUBLIC_KEY)
            .addQueryParameter("ts", timeStamp.toString())
            .addQueryParameter("hash", hash)
            .build()

        val request = original.newBuilder()
            .url(url)
            .build()

        return chain.proceed(request)
    }

}