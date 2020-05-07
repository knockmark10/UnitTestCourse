package com.markoid.core.presentation.navigator

import android.content.Context
import android.content.Intent

class AppNavigator(private val context: Context) {

    fun navigateTo(destination: String) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            setClassName(context, destination)
        }
        context.startActivity(intent)
    }

}