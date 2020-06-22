package com.markoid.cleanbase.user.data.entities.testing

import com.markoid.cleanbase.user.data.entities.requests.LoginRequest
import com.markoid.cleanbase.user.data.entities.schemes.LoginScheme
import com.markoid.core.data.net.entities.BaseResponse
import okhttp3.ResponseBody
import retrofit2.Response

object UserTestData {

    private const val EMAIL = "email@example.com"

    private const val PASSWORD = "passwords"

    private const val ERROR_CODE = 10

    private const val FAILURE_ERROR = "Something went wrong"

    val correctLoginScheme: LoginScheme
        get() = LoginScheme(EMAIL, PASSWORD)

    val correctLoginRequest: LoginRequest
        get() = LoginRequest(EMAIL, PASSWORD)

    val successfulResponse: Response<BaseResponse>
        get() = Response.success(BaseResponse("00", "Success"))

    val failureResponse: Response<BaseResponse>
        get() = Response.error(ERROR_CODE, ResponseBody.create(null, FAILURE_ERROR))

    val emptyUserLoginScheme: LoginScheme
        get() = LoginScheme("", PASSWORD)

    val invalidUserLoginScheme: LoginScheme
        get() = LoginScheme("asdlfikj", PASSWORD)

}