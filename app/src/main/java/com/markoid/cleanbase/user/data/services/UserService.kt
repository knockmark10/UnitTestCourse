package com.markoid.cleanbase.user.data.services

import com.markoid.cleanbase.user.data.entities.requests.LoginRequest
import com.markoid.cleanbase.user.data.entities.requests.RegisterRequest
import com.markoid.core.data.net.entities.BaseResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {

    @POST("/register")
    fun registerUser(@Body user: RegisterRequest): Observable<Response<BaseResponse>>

    @POST("/login")
    fun login(@Body login: LoginRequest): Observable<Response<BaseResponse>>

}