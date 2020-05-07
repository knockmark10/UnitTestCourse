package com.markoid.core.domain.useCases

import io.reactivex.observers.DisposableObserver

interface Interactor<Result, Params> {
    fun execute(observer: DisposableObserver<Result>, params: Params)
}