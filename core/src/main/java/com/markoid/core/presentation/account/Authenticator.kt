package com.markoid.core.presentation.account

import android.Manifest
import android.accounts.AbstractAccountAuthenticator
import android.accounts.Account
import android.accounts.AccountAuthenticatorResponse
import android.accounts.AccountManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.markoid.core.R
import com.markoid.core.presentation.utils.Constants
import javax.inject.Inject

class Authenticator
@Inject constructor(
    private val context: Context,
    private val accountManager: AccountsManager
) : AbstractAccountAuthenticator(context) {

    private val handler = Handler()

    private val mainActivity: String
        get() = StringBuilder()
            .append(getAuthTokenLabel(""))
            .append(Constants.MAIN_ACTIVITY)
            .toString()

    override fun getAuthTokenLabel(p0: String?): String = getString(R.string.app_package_name)

    override fun confirmCredentials(
        p0: AccountAuthenticatorResponse?,
        p1: Account?,
        p2: Bundle?
    ): Bundle? = null

    override fun updateCredentials(
        p0: AccountAuthenticatorResponse?,
        p1: Account?,
        p2: String?,
        p3: Bundle?
    ): Bundle? = null

    override fun getAuthToken(
        p0: AccountAuthenticatorResponse?,
        p1: Account?,
        p2: String?,
        p3: Bundle?
    ): Bundle? = null

    override fun hasFeatures(
        p0: AccountAuthenticatorResponse?,
        p1: Account?,
        p2: Array<out String>?
    ): Bundle? = null

    override fun editProperties(p0: AccountAuthenticatorResponse?, p1: String?): Bundle? = null

    override fun addAccount(
        response: AccountAuthenticatorResponse?,
        accountType: String?,
        authTokenType: String?,
        requiredFeatures: Array<out String>?,
        options: Bundle?
    ): Bundle {
        if (permissionIsGranted()) {
            if (this.accountManager.accountExists()) {
                val message = getString(R.string.only_one_account_per_device)
                val bundle = Bundle()
                bundle.putInt(
                    AccountManager.KEY_ERROR_CODE,
                    AccountManager.ERROR_CODE_UNSUPPORTED_OPERATION
                )
                bundle.putString(AccountManager.KEY_ERROR_MESSAGE, message)
                handler.post { Toast.makeText(context, message, Toast.LENGTH_LONG).show() }
                return bundle
            }
            //Intent for activity without session
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setClassName(context, this.mainActivity)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra(AccountManager.KEY_ACCOUNT_AUTHENTICATOR_RESPONSE, response)
            intent.putExtra(AccountManager.KEY_ACCOUNT_TYPE, accountType)
            val bundle = Bundle()
            bundle.putParcelable(AccountManager.KEY_INTENT, intent)
            return bundle
        }
        val message = context.getString(R.string.required_permissions_message)
        val bundle = Bundle()
        bundle.putInt(
            AccountManager.KEY_ERROR_CODE,
            AccountManager.ERROR_CODE_UNSUPPORTED_OPERATION
        )
        bundle.putString(AccountManager.KEY_ERROR_MESSAGE, message)
        handler.post { Toast.makeText(context, message, Toast.LENGTH_LONG).show() }
        return bundle
    }

    private fun permissionIsGranted(): Boolean =
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1 ||
                ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.GET_ACCOUNTS
                ) == PackageManager.PERMISSION_GRANTED

    private fun getString(resId: Int): String = context.getString(resId)

}