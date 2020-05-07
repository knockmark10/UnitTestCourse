package com.markoid.core.data.net.entities

import com.google.gson.annotations.SerializedName

open class BaseResponse(
    @SerializedName("code") private val _code: String? = null,
    @SerializedName("message") private val _message: String? = null
) {
    val code: String
        get() = this._code ?: ""
    val message: String
        get() = this._message ?: ""
}