package com.clp3z.marvelcompose.repository.models

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import retrofit2.HttpException
import java.io.IOException

typealias Result<T> = Either<Error, T>

sealed class Error {
    object Application : Error()
    data class Network(val code: Int) : Error()
    data class Unknown(val message: String) : Error()
}

fun Exception.toError(): Error = when (this) {
    is IOException -> Error.Application
    is HttpException -> Error.Network(code())
    else -> Error.Unknown(localizedMessage ?: "Unknown error")
}

inline fun <T> tryCall(action: () -> T): Result<T> = try {
    action().right()
} catch (exception: Exception) {
    exception.toError().left()
}

fun Error.toStringMessage() = when (this) {
    Error.Application -> "Application error"
    is Error.Network -> "Network error: $code"
    is Error.Unknown -> "Unknown error: $message"
}