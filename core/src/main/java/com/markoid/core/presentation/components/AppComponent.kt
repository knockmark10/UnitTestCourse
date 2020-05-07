package com.markoid.core.presentation.components

import android.accounts.AccountManager
import android.app.Application
import android.content.res.Resources
import com.markoid.core.data.repository.AppDatabase
import com.markoid.core.domain.executors.PostExecutionThread
import com.markoid.core.domain.executors.ThreadExecutor
import com.markoid.core.presentation.account.AccountsManager
import com.markoid.core.presentation.account.Authenticator
import com.markoid.core.presentation.managers.UserDataManager
import com.markoid.core.presentation.modules.AppModule
import com.markoid.core.presentation.modules.AuthenticationModule
import com.markoid.core.presentation.modules.NetModule
import com.markoid.core.presentation.modules.RepositoryModule
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        RepositoryModule::class,
        AuthenticationModule::class
    ]
)
interface AppComponent {

    fun applicationContext(): Application

    fun resources(): Resources

    fun userDataManager(): UserDataManager

    fun threadExecutor(): ThreadExecutor

    fun postExecutionThread(): PostExecutionThread

    fun retrofit(): Retrofit

    fun database(): AppDatabase

    fun accountManager(): AccountManager

    fun accountsManager(): AccountsManager

    fun authenticator(): Authenticator

}