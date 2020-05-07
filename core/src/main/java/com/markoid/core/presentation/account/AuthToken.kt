package com.markoid.core.presentation.account

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable

data class AuthToken(val token: String, val anotherParameter: String) : Parcelable {

    val bundle: Bundle
        get() = Bundle().apply {
            putString(TOKEN_KEY, this@AuthToken.token)
            putString(PARAMETER_KEY, this@AuthToken.anotherParameter)
        }

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(token)
        parcel.writeString(anotherParameter)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AuthToken> {

        const val TOKEN_KEY = "token.key"

        const val PARAMETER_KEY = "parameter.key"

        override fun createFromParcel(parcel: Parcel): AuthToken {
            return AuthToken(parcel)
        }

        override fun newArray(size: Int): Array<AuthToken?> {
            return arrayOfNulls(size)
        }
    }

}