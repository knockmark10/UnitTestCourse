package com.markoid.core.domain.exceptions

import java.io.IOException

class ServerException(
    private val errorMessage: String = "Server error"
) : IOException() {

    override fun getLocalizedMessage(): String? = this.errorMessage

}