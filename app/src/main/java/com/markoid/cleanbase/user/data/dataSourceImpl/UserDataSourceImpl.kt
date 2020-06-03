package com.markoid.cleanbase.user.data.dataSourceImpl

import com.markoid.cleanbase.user.data.entities.LoginRequest
import com.markoid.cleanbase.user.data.entities.RegisterRequest
import com.markoid.cleanbase.user.data.services.UserService
import com.markoid.cleanbase.user.domain.dataSourceAbstraction.UserDataSource
import io.reactivex.Observable
import javax.inject.Inject

class UserDataSourceImpl
@Inject constructor(
    private val userService: UserService
) : UserDataSource {

    override fun register(registerRequest: RegisterRequest): Observable<Unit> = TODO()

    override fun login(loginRequest: LoginRequest): Observable<Unit> = TODO()

}