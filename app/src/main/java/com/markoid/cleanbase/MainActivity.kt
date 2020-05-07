package com.markoid.cleanbase

import android.os.Bundle
import com.markoid.core.presentation.account.AuthToken
import com.markoid.core.presentation.activities.BaseActivity
import com.markoid.core.presentation.extensions.intentFor
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor

class MainActivity : BaseActivity() {

    override fun getLayout(): Int =
        R.layout.activity_main

    override fun initView(savedInstanceState: Bundle?) {

        this.login_btn.setOnClickListener {
            this.accountsManager.addAccountExplicitly(
                AuthToken("1234", "1234").bundle
            )
            startActivity(intentFor<AuthenticatedActivity>())
            finish()
        }

    }

}
