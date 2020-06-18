package com.markoid.cleanbase.user.data.mappers

import com.markoid.cleanbase.user.data.entities.requests.LoginRequest
import com.markoid.cleanbase.user.data.entities.requests.RegisterRequest
import com.markoid.cleanbase.user.data.entities.schemes.LoginScheme
import com.markoid.cleanbase.user.data.entities.schemes.RegisterScheme
import javax.inject.Inject

class UserMapper @Inject constructor() {

    fun mapRegisterSchemeToRegisterRequest(scheme: RegisterScheme): RegisterRequest = TODO()

    fun mapLoginSchemeToLoginRequest(scheme: LoginScheme): LoginRequest = with(scheme) {
        LoginRequest(email, password)
    }

}