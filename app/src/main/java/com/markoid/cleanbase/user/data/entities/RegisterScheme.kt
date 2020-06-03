package com.markoid.cleanbase.user.data.entities

data class RegisterScheme(
    val name: String = "",
    val lastName: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = ""
)