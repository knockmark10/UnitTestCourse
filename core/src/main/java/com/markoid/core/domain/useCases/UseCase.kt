package com.markoid.core.domain.useCases

import com.markoid.core.domain.executors.PostExecutionThread
import com.markoid.core.domain.executors.ThreadExecutor
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

abstract class UseCase<Result, Params>(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread
) : Interactor<Result, Params> {

    private var isTestEnabled = false

    abstract fun createObservable(params: Params): Observable<Result>

    private val disposables: CompositeDisposable by lazy { CompositeDisposable() }

    override fun execute(observer: DisposableObserver<Result>, params: Params) {
        val observable: Observable<Result> = this.createObservable(params)
            .subscribeOn(Schedulers.from(this.threadExecutor))
            .observeOn(this.postExecutionThread.getScheduler())
        this.disposables.add(observable.subscribeWith(observer))
    }

    fun dispose() {
        if (!this.disposables.isDisposed) {
            this.disposables.dispose()
        }
    }

    fun enableTestingEnvironment(enable: Boolean) {
        this.isTestEnabled = enable
    }

    open fun uiThread(): Scheduler =
        if (this.isTestEnabled) Schedulers.trampoline() else AndroidSchedulers.mainThread()

    open fun ioThread(): Scheduler =
        if (this.isTestEnabled) Schedulers.trampoline() else Schedulers.io()

}