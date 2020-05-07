package com.markoid.core.presentation.account

import android.accounts.Account
import android.accounts.AccountManager
import android.app.Activity
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import com.markoid.core.R
import com.markoid.core.presentation.account.AuthToken.CREATOR.PARAMETER_KEY
import com.markoid.core.presentation.account.AuthToken.CREATOR.TOKEN_KEY
import com.markoid.core.presentation.utils.Constants
import java.lang.ref.WeakReference
import javax.inject.Inject

class AccountsManager
@Inject constructor(
    private val resources: Resources,
    private val accountManager: AccountManager
) {

    private val accountType: String
        get() = this.resources.getString(R.string.app_package_name)

    private val token: String
        get() = this.getUserData(TOKEN_KEY)

    private val parameter: String
        get() = this.getUserData(PARAMETER_KEY)

    fun accountExists(): Boolean =
        this.getAllAccounts().any()

    fun getAllAccounts(): Array<Account> =
        this.accountManager.getAccountsByType(this.accountType)

    fun getAppAccount(): Account? =
        this.getAllAccounts().firstOrNull()

    fun getAuthToken(): AuthToken =
        AuthToken(this.token, this.parameter)

    fun addAccount(activity: WeakReference<Activity>?) {
        activity?.get()?.let {
            this.accountManager.addAccount(
                this.accountType,
                null,
                null,
                null,
                it,
                null,
                null
            )
        }
    }

    fun addAccountExplicitly(bundle: Bundle): Boolean = this.addAccountExplicitly(
        Account(Constants.ACCOUNT_NAME, this.accountType),
        Constants.ACCOUNT_HINT,
        bundle
    )

    fun removeAccountFromManager(activity: WeakReference<Activity>) {
        activity.get()?.let { act -> getAppAccount()?.let { acc -> removeAccount(acc, act) } }
    }

    fun removeAllAccounts(activity: WeakReference<Activity>?) {
        activity?.get()?.let { act -> this.getAllAccounts().forEach { removeAccount(it, act) } }
    }

    private fun getUserData(key: String): String =
        this.accountManager.getUserData(getAppAccount(), key) ?: ""

    private fun addAccountExplicitly(account: Account, password: String, bundle: Bundle): Boolean =
        this.accountManager.addAccountExplicitly(account, password, bundle)

    private fun removeAccount(account: Account, activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            accountManager.removeAccount(account, activity, null, null)
        } else {
            accountManager.removeAccount(account, null, null)
        }
    }

}

