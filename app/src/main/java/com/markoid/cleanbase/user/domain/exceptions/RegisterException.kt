package com.markoid.cleanbase.user.domain.exceptions

class RegisterException(
    val type: Type,
    val message: String = "RegisterException: $type"
) {

    enum class Type {
        INVALID_NAME,
        INVALID_LAST_NAME,
        INVALID_EMAIL,
        INVALID_PASSWORD,
        PASSWORDS_DO_NOT_MATCH,
    }

}