package com.markoid.core.presentation.modules

import android.accounts.AccountManager
import android.app.Application
import android.content.Context
import android.content.res.Resources
import com.markoid.core.domain.executors.JobExecutor
import com.markoid.core.domain.executors.PostExecutionThread
import com.markoid.core.domain.executors.ThreadExecutor
import com.markoid.core.domain.executors.UiThread
import com.markoid.core.presentation.account.AccountsManager
import com.markoid.core.presentation.managers.UserDataManager
import dagger.Module
import dagger.Provides
import org.jetbrains.anko.accountManager
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @Provides
    @Singleton
    fun providesApplication(): Application = this.application

    @Provides
    @Singleton
    fun providesContext(): Context = this.application.applicationContext

    @Provides
    @Singleton
    fun provideResources(): Resources = application.resources

    @Provides
    @Singleton
    fun providesThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor = jobExecutor

    @Provides
    @Singleton
    fun providesPostExecutionThread(uiThread: UiThread): PostExecutionThread = uiThread

    @Provides
    @Singleton
    fun providesUserDataManager(context: Context): UserDataManager = UserDataManager(context)



}