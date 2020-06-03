package com.markoid.cleanbase.user.data.dataSourceImpl

import com.markoid.cleanbase.user.data.entities.requests.LoginRequest
import com.markoid.cleanbase.user.data.entities.requests.RegisterRequest
import com.markoid.cleanbase.user.data.services.UserService
import com.markoid.cleanbase.user.domain.dataSourceAbstraction.UserDataSource
import com.markoid.core.data.net.entities.BaseResponse
import io.reactivex.Observable
import javax.inject.Inject

class UserDataSourceImpl
@Inject constructor(
    private val userService: UserService
) : UserDataSource {

    override fun register(registerRequest: RegisterRequest): Observable<BaseResponse> = TODO()

    override fun login(loginRequest: LoginRequest): Observable<BaseResponse> = TODO()

}