package com.markoid.core.presentation.states

sealed class BaseState<out T> {
    class Data<T>(val data: T) : BaseState<T>()
    class ProgressVisibility<T>(val visibility: Int) : BaseState<T>()
    class Error<T>(val error:String) : BaseState<T>()
}