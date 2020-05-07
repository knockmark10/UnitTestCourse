package com.markoid.core.domain.interceptors

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.markoid.core.domain.exceptions.ServerException
import okhttp3.Interceptor
import okhttp3.Response

class NetworkInterceptor(private val mContext: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response = if (!isConnected()) {
        throw ServerException()
    } else {
        val builder = chain.request().newBuilder()
        chain.proceed(builder.build())
    }

    private fun isConnected(): Boolean {
        val connectivityManager: ConnectivityManager =
            mContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
        return netInfo != null && netInfo.isConnected
    }

}