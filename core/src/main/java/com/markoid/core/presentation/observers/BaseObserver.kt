package com.markoid.core.presentation.observers

import android.content.res.Resources
import android.view.View
import com.markoid.core.presentation.lifecycle.SmartLiveData
import com.markoid.core.presentation.managers.Reporter
import io.reactivex.observers.DisposableObserver

abstract class BaseObserver<Result, State>(
    private val mResources: Resources,
    private val liveData: SmartLiveData<State>? = null
) : DisposableObserver<Result>() {

    abstract fun onProgressVisibility(visibility: Int): State

    abstract fun onHandleData(data: Result): State

    abstract fun onHandleError(error: Throwable): State

    private fun notifyState(state: State) {
        this.liveData?.value = state
    }

    fun getString(resId: Int): String =
        this.mResources.getString(resId)

    override fun onStart() {
        notifyState(this.onProgressVisibility(View.VISIBLE))
        super.onStart()
    }

    override fun onComplete() {
        notifyState(this.onProgressVisibility(View.GONE))
    }

    override fun onNext(t: Result) {
        notifyState(this.onHandleData(t))
    }

    override fun onError(e: Throwable) {
        this.onComplete()
        Reporter.error(e)
        notifyState(this.onHandleError(e))
    }

}