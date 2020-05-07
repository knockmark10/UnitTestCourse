package com.markoid.core

import android.app.Application
import android.content.Context
import com.markoid.core.presentation.components.AppComponent
import com.markoid.core.presentation.components.DaggerAppComponent
import com.markoid.core.presentation.modules.AppModule
import com.markoid.core.presentation.modules.AuthenticationModule
import com.markoid.core.presentation.modules.NetModule
import com.markoid.core.presentation.modules.RepositoryModule
import com.markoid.core.presentation.utils.Constants
import timber.log.Timber

class CleanApp : Application() {

    val applicationComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .netModule(NetModule(""))
            .repositoryModule(RepositoryModule(Constants.DATABASE_NAME))
            .authenticationModule(AuthenticationModule())
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        setupTimber()
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }

}

fun Context.getAppComponent(): AppComponent {
    val app = this.applicationContext as CleanApp
    return app.applicationComponent
}