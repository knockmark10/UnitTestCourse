package com.markoid.core.presentation.account

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.markoid.core.getAppComponent

class AuthenticatorService : Service() {

    private val authenticator by lazy { getAppComponent().authenticator() }

    override fun onBind(p0: Intent?): IBinder? =
        this.authenticator.iBinder

}