package com.markoid.core.presentation.managers

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

class UserDataManager(private val mContext: Context) {

    companion object {
        const val EXAMPLE_KEY= "example.key"
    }

    private val mPreferences by lazy { SharedPreferencesManager(this.mContext) }

    fun wipeOutData() {
        this.mPreferences.cleanAllPreferences()
    }

    private inner class SharedPreferencesManager(mContext: Context) {

        private val sharedPreferences: SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(mContext)

        fun setSharedPreference(key: String, value: Any) {
            when (value) {
                is Int -> sharedPreferences.edit().putInt(key, value).apply()
                is Float -> sharedPreferences.edit().putFloat(key, value).apply()
                is Long -> sharedPreferences.edit().putLong(key, value).apply()
                is Boolean -> sharedPreferences.edit().putBoolean(key, value).apply()
                is String -> sharedPreferences.edit().putString(key, value).apply()
                else -> throw UnsupportedOperationException("Value type not supported.")
            }
        }

        inline fun <reified T : Any> getSharedPreference(key: String, defaultValue: T? = null): T =
            when (T::class) {
                Int::class -> sharedPreferences.getInt(key, defaultValue as? Int ?: -1) as T
                Float::class -> sharedPreferences.getFloat(key, defaultValue as? Float ?: -1f) as T
                Long::class -> sharedPreferences.getLong(key, defaultValue as? Long ?: -1L) as T
                Boolean::class ->
                    sharedPreferences.getBoolean(key, defaultValue as? Boolean ?: false) as T
                String::class ->
                    sharedPreferences.getString(key, defaultValue as? String ?: "") as T
                else ->
                    throw UnsupportedOperationException("Value type not supported. You need to specify default value with proper type.")
            }

        fun clearPreferences(preferenceName: String) =
            sharedPreferences.edit().remove(preferenceName).apply()

        fun cleanAllPreferences() =
            sharedPreferences.edit().clear().apply()
    }

}