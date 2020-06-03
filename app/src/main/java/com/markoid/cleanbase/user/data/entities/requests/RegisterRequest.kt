package com.markoid.cleanbase.user.data.entities.requests

import com.google.gson.annotations.SerializedName

data class RegisterRequest(

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("lastName")
    val lastName: String? = null,

    @SerializedName("email")
    val email: String? = null,

    @SerializedName("password")
    val password: String? = null,

    @SerializedName("confirmPassword")
    val confirmPassword: String? = null

)