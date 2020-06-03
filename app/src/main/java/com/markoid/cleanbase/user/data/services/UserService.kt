package com.markoid.cleanbase.user.data.services

import com.markoid.cleanbase.user.data.entities.LoginRequest
import com.markoid.cleanbase.user.data.entities.RegisterRequest
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {

    @POST("/register")
    fun registerUser(@Body user: RegisterRequest): Observable<Unit>

    @POST("/login")
    fun registerUser(@Body login: LoginRequest): Observable<Unit>

}