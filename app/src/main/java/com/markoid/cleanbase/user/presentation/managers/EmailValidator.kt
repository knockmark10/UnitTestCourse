package com.markoid.cleanbase.user.presentation.managers

import android.util.Patterns
import javax.inject.Inject

class EmailValidator @Inject constructor() {

    fun isEmailValid(email: String?): Boolean =
        !email.isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()

}