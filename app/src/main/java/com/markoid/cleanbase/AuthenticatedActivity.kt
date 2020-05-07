package com.markoid.cleanbase

import android.os.Bundle
import com.markoid.core.presentation.activities.BaseAuthenticationActivity
import kotlinx.android.synthetic.main.activity_authenticated.*

class AuthenticatedActivity : BaseAuthenticationActivity() {

    override fun getLayout(): Int = R.layout.activity_authenticated

    override fun initView(savedInstanceState: Bundle?) {

        this.logout_btn.setOnClickListener {
            this.removeLocalAccount()
        }

    }


}