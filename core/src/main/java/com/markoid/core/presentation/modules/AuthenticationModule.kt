package com.markoid.core.presentation.modules

import android.accounts.AccountManager
import android.content.Context
import android.content.res.Resources
import com.markoid.core.presentation.account.AccountsManager
import com.markoid.core.presentation.account.Authenticator
import dagger.Module
import dagger.Provides
import org.jetbrains.anko.accountManager
import javax.inject.Singleton

@Module
class AuthenticationModule {

    @Provides
    @Singleton
    fun providesAccountManager(context: Context): AccountManager = context.accountManager

    @Provides
    @Singleton
    fun providesAccountsManager(
        resources: Resources,
        accountManager: AccountManager
    ): AccountsManager = AccountsManager(resources, accountManager)

    @Provides
    @Singleton
    fun providesAuthenticator(context: Context, accountsManager: AccountsManager): Authenticator =
        Authenticator(context, accountsManager)

}