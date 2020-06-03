package com.markoid.cleanbase.user.data.entities.requests

import com.google.gson.annotations.SerializedName

data class LoginRequest(

    @SerializedName("email")
    val email: String? = null,

    @SerializedName("password")
    val password: String? = null

)