package com.markoid.cleanbase.user.data.dataSourceImpl

import com.markoid.cleanbase.user.data.entities.testing.UserTestData
import com.markoid.cleanbase.user.data.services.UserService
import com.markoid.core.data.net.entities.BaseResponse
import com.markoid.core.data.net.handler.ApiResponseHandler
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response

@RunWith(MockitoJUnitRunner.Silent::class)
class UserDataSourceImplTest {

    // ---------START CONSTANTS--------------

    // -----------END CONSTANTS--------------

    // -----------START HELPER---------------

    @Mock
    lateinit var mUserServiceMock: UserService

    @Mock
    lateinit var mApiHandlerMock: ApiResponseHandler

    // -----------END HELPER-----------------

    private lateinit var SUT: UserDataSourceImpl

    @Before
    fun setup() {
        this.SUT = UserDataSourceImpl(
            this.mUserServiceMock,
            this.mApiHandlerMock
        )
        successResponse()
    }

    @Test
    fun login_requestPassedToEndpoint() {
        // Arrange
        // Act
        this.SUT.login(UserTestData.correctLoginRequest)
        // Assert
        verify(this.mUserServiceMock).login(any())
    }

    @Test
    fun login_responseHandledCorrectly() {
        // Arrange
        doReturn(Observable.just(BaseResponse()))
            .`when`(this.mApiHandlerMock)
            .handle<Response<BaseResponse>>(any())
        // Act
        this.SUT.login(UserTestData.correctLoginRequest).test()
        // Assert
        verify(this.mApiHandlerMock, times(1))
            .handle<Response<BaseResponse>>(any())
    }

    // -----------START HELPER METHODS--------
    private fun successResponse() {
        doReturn(Observable.just(UserTestData.successfulResponse))
            .`when`(this.mUserServiceMock)
            .login(any())
    }

    // -----------END HELPER METHODS----------

}