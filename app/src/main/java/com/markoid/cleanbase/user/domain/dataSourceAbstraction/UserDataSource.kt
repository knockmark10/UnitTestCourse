package com.markoid.cleanbase.user.domain.dataSourceAbstraction

import com.markoid.cleanbase.user.data.entities.requests.LoginRequest
import com.markoid.cleanbase.user.data.entities.requests.RegisterRequest
import com.markoid.core.data.net.entities.BaseResponse
import io.reactivex.Observable

interface UserDataSource {
    fun register(registerRequest: RegisterRequest): Observable<BaseResponse>
    fun login(loginRequest: LoginRequest): Observable<BaseResponse>
}