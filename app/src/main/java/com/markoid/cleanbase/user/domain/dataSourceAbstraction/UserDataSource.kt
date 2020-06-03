package com.markoid.cleanbase.user.domain.dataSourceAbstraction

import com.markoid.cleanbase.user.data.entities.LoginRequest
import com.markoid.cleanbase.user.data.entities.RegisterRequest
import io.reactivex.Observable

interface UserDataSource {
    fun register(registerRequest: RegisterRequest): Observable<Unit>
    fun login(loginRequest: LoginRequest): Observable<Unit>
}