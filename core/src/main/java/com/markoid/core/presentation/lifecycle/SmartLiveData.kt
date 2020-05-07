package com.markoid.core.presentation.lifecycle

class SmartLiveData<T> : BaseLiveData<T>() {

    var value: T?
        set(value) = value?.let { setNextValue(it) }
            ?: throw NullPointerException("You cannot set null value for SmartLiveData")
        get() = nextValue

    public override fun postValue(value: T) {
        super.postValue(value)
    }

    public override fun setNextValue(value: T) {
        super.setNextValue(value)
    }

}