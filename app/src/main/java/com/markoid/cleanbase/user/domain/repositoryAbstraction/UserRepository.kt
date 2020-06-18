package com.markoid.cleanbase.user.domain.repositoryAbstraction

import com.markoid.cleanbase.user.data.entities.requests.RegisterRequest
import com.markoid.cleanbase.user.data.entities.schemes.LoginScheme
import com.markoid.core.data.net.entities.BaseResponse
import io.reactivex.Observable

interface UserRepository {
    fun register(registerRequest: RegisterRequest): Observable<BaseResponse>
    fun login(loginScheme: LoginScheme): Observable<BaseResponse>
}