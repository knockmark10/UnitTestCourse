package com.markoid.core.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.markoid.core.R
import com.markoid.core.getAppComponent
import com.markoid.core.presentation.components.AppComponent
import com.markoid.core.presentation.managers.UserDataManager

abstract class BaseActivity : AppCompatActivity() {

    val appComponent: AppComponent by lazy { this.application.getAppComponent() }

    val userDataManager: UserDataManager by lazy { this.appComponent.userDataManager() }

    val accountsManager by lazy { getAppComponent().accountsManager() }

    private val transitions by lazy {
        Transitions(
            R.anim.left_in,
            R.anim.left_out,
            R.anim.right_in,
            R.anim.right_out
        )
    }

    abstract fun getLayout(): Int

    abstract fun initView(savedInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {

        this.playEnterAnimations()

        super.onCreate(savedInstanceState)

        this.setContentView(getLayout())

        this.initView(savedInstanceState)

    }

    private fun playEnterAnimations() {
        this.overridePendingTransition(
            this.transitions.onCreateEnterAnimation,
            this.transitions.onCreateExitAnimation
        )
    }

    private fun playBackAnimations() {
        this.overridePendingTransition(
            this.transitions.onBackPressedEnterAnimation,
            this.transitions.onBackPressedExitAnimation
        )
    }

    override fun onBackPressed() {
        this.playBackAnimations()
        super.onBackPressed()
    }

    fun replaceFragment(container: Int, fragment: Fragment, addToBackStack: Boolean) {
        val transaction = this.supportFragmentManager
            .beginTransaction()
            .replace(container, fragment)
        if (addToBackStack) transaction.addToBackStack(fragment::class.java.name)
        transaction.commit()
    }

    fun addFragment(container: Int, fragment: Fragment, addToBackStack: Boolean) {
        val transaction = this.supportFragmentManager
            .beginTransaction()
            .add(container, fragment)
        if (addToBackStack) transaction.addToBackStack(fragment::class.java.name)
        transaction.commit()
    }

    class Transitions(
        val onCreateEnterAnimation: Int,
        val onCreateExitAnimation: Int,
        val onBackPressedEnterAnimation: Int,
        val onBackPressedExitAnimation: Int
    )

}