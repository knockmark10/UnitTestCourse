package com.markoid.cleanbase.user.data.mappers

import com.markoid.cleanbase.user.data.entities.LoginRequest
import com.markoid.cleanbase.user.data.entities.LoginScheme
import com.markoid.cleanbase.user.data.entities.RegisterRequest
import com.markoid.cleanbase.user.data.entities.RegisterScheme
import javax.inject.Inject

class UserMapper @Inject constructor() {

    fun mapRegisterSchemeToRegisterRequest(scheme: RegisterScheme): RegisterRequest = TODO()

    fun mapLoginSchemeToLoginRequest(scheme: LoginScheme): LoginRequest = TODO()

}