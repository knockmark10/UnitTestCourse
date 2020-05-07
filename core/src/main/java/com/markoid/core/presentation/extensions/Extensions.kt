package com.markoid.core.presentation.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.location.LocationManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import com.markoid.core.presentation.lifecycle.SmartLiveData
import com.markoid.core.presentation.managers.Reporter
import org.jetbrains.anko.locationManager
import java.io.Serializable

fun <T> SmartLiveData<T>.observe(
    viewLifecycleOwner: LifecycleOwner,
    output: (response: T) -> Unit
) {
    if (!this.hasObservers()) {
        this.observe(viewLifecycleOwner, Observer(output))
    }
}

fun <T> LiveData<T>.observe(
    viewLifecycleOwner: LifecycleOwner,
    output: (response: T) -> Unit
) {
    if (!this.hasObservers()) {
        this.observe(viewLifecycleOwner, Observer(output))
    }
}

@Suppress("UNCHECKED_CAST")
fun <F : Fragment> AppCompatActivity.findFragmentByClassName(fragmentClass: Class<F>): F? {
    val navHostFragment = supportFragmentManager.primaryNavigationFragment as? NavHostFragment
    val desiredFragment = navHostFragment?.childFragmentManager?.primaryNavigationFragment as? F
    if (desiredFragment != null) {
        return desiredFragment
    } else {
        navHostFragment?.childFragmentManager?.fragments?.forEach {
            if (fragmentClass.isAssignableFrom(it.javaClass)) {
                return it as? F
            }
        }
    }
    return null
}

fun View.show(show: Boolean) {
    val visibility = if (show) View.VISIBLE else View.GONE
    this.visibility = visibility
}

fun View.isVisible(): Boolean = this.visibility == View.VISIBLE

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

inline fun <reified T : AppCompatActivity> Activity.intentFor(
    extraName: String? = null,
    extras: Any? = null
): Intent = Intent(this, T::class.java).apply {
    extras?.let {
        when (it) {
            is String -> putExtra(extraName, it)
            is Int -> putExtra(extraName, it)
            is Float -> putExtra(extraName, it)
            is Double -> putExtra(extraName, it)
            is Boolean -> putExtra(extraName, it)
            is Serializable -> putExtra(extraName, it)
            else -> throw IllegalArgumentException("Wrong extra for argument $it")
        }
    }
}

inline fun <reified T : AppCompatActivity> Fragment.intentFor(
    extraName: String? = null,
    extras: Any? = null
): Intent = Intent(requireActivity(), T::class.java).apply {
    extras?.let {
        when (it) {
            is String -> putExtra(extraName, it)
            is Int -> putExtra(extraName, it)
            is Float -> putExtra(extraName, it)
            is Double -> putExtra(extraName, it)
            is Boolean -> putExtra(extraName, it)
            is Serializable -> putExtra(extraName, it)
            else -> throw IllegalArgumentException("Wrong extra for argument $it")
        }
    }
}

inline fun <reified T : Any> String.toSafeValue(defaultValue: T): T = try {
    when (T::class) {
        Int::class -> this.toInt() as T
        Float::class -> this.toFloat() as T
        Long::class -> this.toLong() as T
        else -> throw UnsupportedOperationException("Value type not supported. You need to specify default value with proper type.")
    }
} catch (e: Exception) {
    when (T::class) {
        Int::class -> defaultValue
        Float::class -> defaultValue
        Long::class -> defaultValue
        else -> throw UnsupportedOperationException("Value type not supported. You need to specify default value with proper type.")
    }
}

fun String.skip(number: Int): String =
    if (number >= this.length) "" else this.substring(number)

fun ViewGroup.inflate(layoutRes: Int): View =
    LayoutInflater.from(this.context).inflate(layoutRes, this, false)

fun Context.areLocationServicesEnabled(): Boolean {
    val manager = this.locationManager
    var gpsEnabled = false
    var networkEnabled = false
    try {
        gpsEnabled = manager.isProviderEnabled(LocationManager.GPS_PROVIDER)
    } catch (exception: Throwable) {
        Reporter.error(exception)
    }
    try {
        networkEnabled = manager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    } catch (exception: Throwable) {
        Reporter.error(exception)
    }
    return gpsEnabled || networkEnabled
}