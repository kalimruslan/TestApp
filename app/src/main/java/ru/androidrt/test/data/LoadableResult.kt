package ru.androidrt.test.data

sealed class LoadableResult<R> {
    class Loading<R>: LoadableResult<R>()
    class Success<R>(val value: R): LoadableResult<R>()
    class Failure<R>(val throwable: Throwable) : LoadableResult<R>()

    companion object{
        fun <R> loading(): LoadableResult<R> = Loading()
        fun <R> success(value: R): LoadableResult<R> = Success(value)
        fun <R> failure(throwable: Throwable): LoadableResult<R> = Failure(throwable)
    }

    val isLoading: Boolean get() = this is Loading
    val isSuccess: Boolean get() = this is Success
    val isFailure: Boolean get() = this is Failure
}