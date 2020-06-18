package com.markoid.cleanbase.user.data.repositoryImpl

import com.markoid.cleanbase.user.data.dataSourceImpl.UserDataSourceImpl
import com.markoid.cleanbase.user.data.entities.requests.RegisterRequest
import com.markoid.cleanbase.user.data.entities.schemes.LoginScheme
import com.markoid.cleanbase.user.data.mappers.UserMapper
import com.markoid.cleanbase.user.domain.repositoryAbstraction.UserRepository
import com.markoid.core.data.net.entities.BaseResponse
import io.reactivex.Observable
import javax.inject.Inject

class UserRepositoryImpl
@Inject constructor(
    private val userMapper: UserMapper,
    private val userDataSourceImpl: UserDataSourceImpl
) : UserRepository {

    override fun register(registerRequest: RegisterRequest): Observable<BaseResponse> = TODO()

    override fun login(loginScheme: LoginScheme): Observable<BaseResponse> =
        Observable.just(this.userMapper.mapLoginSchemeToLoginRequest(loginScheme))
            .flatMap { this.userDataSourceImpl.login(it) }

}