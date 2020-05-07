package com.markoid.core.presentation.activities

import android.accounts.Account
import android.accounts.OnAccountsUpdateListener
import com.markoid.core.getAppComponent
import com.markoid.core.presentation.account.AuthToken
import java.lang.ref.WeakReference

abstract class BaseAuthenticationActivity : BaseActivity(), OnAccountsUpdateListener {

    private var isAccountListenerSet: Boolean = false


    private val accountManager by lazy { getAppComponent().accountManager() }

    val authToken: AuthToken
        get() = this.accountsManager.getAuthToken()

    override fun onStart() {
        super.onStart()
        if (!this.isAccountListenerSet) addAccountUpdateListener()
    }

    fun removeLocalAccount() = with(this.accountsManager) {
        //Check if account exists
        if (accountExists()) {
            //Check if there is more than one account saved
            if (getAllAccounts().size > 1) {
                //Remove all accounts
                removeAllAccounts(WeakReference(this@BaseAuthenticationActivity))
            } else {
                //Remove account
                removeAccountFromManager(WeakReference(this@BaseAuthenticationActivity))
            }
        }
    }

    private fun addAccountUpdateListener() {
        this.accountManager.addOnAccountsUpdatedListener(this, null, true)
        this.isAccountListenerSet = true
    }

    override fun onAccountsUpdated(accounts: Array<out Account>?) {
        if (this.accountsManager.accountExists()) {
            if (this.authToken.token.isEmpty()) removeLocalAccount()
        } else {
            this.accountsManager.addAccount(WeakReference(this))
        }
    }

}