package com.markoid.core.presentation.managers

import timber.log.Timber

object Reporter {

    fun error(message: String, vararg args: Any) {
        Timber.e(message, args)
    }

    fun error(throwable: Throwable, message: String, vararg args: Any) {
        Timber.e(throwable, message, args)
    }

    fun error(throwable: Throwable) {
        Timber.e(throwable)
    }

    private fun reportToAnalytics(throwable: Throwable){

    }

}