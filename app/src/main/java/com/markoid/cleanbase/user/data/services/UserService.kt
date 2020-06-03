package com.markoid.cleanbase.user.data.services

import com.markoid.cleanbase.user.data.entities.requests.LoginRequest
import com.markoid.cleanbase.user.data.entities.requests.RegisterRequest
import com.markoid.core.data.net.entities.BaseResponse
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {

    @POST("/register")
    fun registerUser(@Body user: RegisterRequest): Observable<BaseResponse>

    @POST("/login")
    fun registerUser(@Body login: LoginRequest): Observable<BaseResponse>

}