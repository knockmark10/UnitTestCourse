package com.markoid.core.data.net.handler

import com.markoid.core.data.net.entities.BaseResponse
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class ApiResponseHandler
@Inject constructor(private val retrofit: Retrofit) {

    fun <T> handle(response: Response<T>): Observable<T> =
        if (response.isSuccessful) {
            val body = response.body()
            if (body != null) {
                Observable.just(body)
            } else {
                Observable.error(Throwable("Response body is null"))
            }
        } else {
            val errorBody = response.errorBody()
            if (errorBody != null) {
                val converter: Converter<ResponseBody, BaseResponse> =
                    this.retrofit.responseBodyConverter(
                        BaseResponse::class.java,
                        arrayOf()
                    )

                val apiError = converter.convert(errorBody)

                if (apiError != null) {
                    Observable.error(Throwable(apiError.code))
                } else {
                    Observable.error(Throwable("Unable to parse error body"))
                }
            } else {
                Observable.error(Throwable("Error body is null"))
            }
        }

}