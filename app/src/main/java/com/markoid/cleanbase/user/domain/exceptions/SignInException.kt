package com.markoid.cleanbase.user.domain.exceptions

class SignInException(
    val type: Type,
    val mMessage: String = "SignInException: $type"
) : Throwable() {


    enum class Type {
        USER_ERROR,
        INVALID_FORMAT_ERROR
    }

}