package com.markoid.cleanbase.user.data.repositoryImpl

import com.markoid.cleanbase.user.data.dataSourceImpl.UserDataSourceImpl
import com.markoid.cleanbase.user.data.entities.requests.LoginRequest
import com.markoid.cleanbase.user.data.entities.requests.RegisterRequest
import com.markoid.cleanbase.user.data.mappers.UserMapper
import com.markoid.cleanbase.user.domain.repositoryAbstraction.UserRepository
import com.markoid.core.data.net.entities.BaseResponse
import io.reactivex.Observable
import javax.inject.Inject

class UserRepositoryImpl
@Inject constructor(
    private val userMapper: UserMapper,
    private val registerDataSourceImpl: UserDataSourceImpl
) : UserRepository {

    override fun register(registerRequest: RegisterRequest): Observable<BaseResponse> = TODO()

    override fun login(loginRequest: LoginRequest): Observable<BaseResponse> = TODO()

}