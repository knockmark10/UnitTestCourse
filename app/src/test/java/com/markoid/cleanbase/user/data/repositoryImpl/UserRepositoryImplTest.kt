package com.markoid.cleanbase.user.data.repositoryImpl

import com.markoid.cleanbase.user.data.dataSourceImpl.UserDataSourceImpl
import com.markoid.cleanbase.user.data.entities.testing.UserTestData
import com.markoid.cleanbase.user.data.mappers.UserMapper
import com.markoid.core.data.net.entities.BaseResponse
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UserRepositoryImplTest {

    // ---------START CONSTANTS--------------

    // -----------END CONSTANTS--------------

    // -----------START HELPER---------------
    @Spy
    lateinit var mUserMapperMock: UserMapper

    @Mock
    lateinit var mUserDataSourceImplMock: UserDataSourceImpl

    // -----------END HELPER-----------------

    private lateinit var SUT: UserRepositoryImpl

    @Before
    fun setup() {
        this.SUT = UserRepositoryImpl(
            this.mUserMapperMock,
            this.mUserDataSourceImplMock
        )
        baseResponse()
    }

    @Test
    fun login_noErrorsFound() {
        // Arrange
        // Act
        val result = this.SUT.login(UserTestData.correctLoginScheme).test()
        // Assert
        result.assertNoErrors()
    }

    @Test
    fun login_requestPassedToMapper() {
        // Arrange
        // Act
        this.SUT.login(UserTestData.correctLoginScheme).test()
        // Assert
        verify(this.mUserMapperMock).mapLoginSchemeToLoginRequest(any())
    }

    @Test
    fun login_mappedObjectsPassedToDataSource() {
        // Arrange
        // Act
        this.SUT.login(UserTestData.correctLoginScheme).test()
        // Assert
        verify(this.mUserDataSourceImplMock).login(any())
    }

    // -----------START HELPER METHODS--------
    private fun baseResponse() {
        doReturn(Observable.just(BaseResponse()))
            .`when`(this.mUserDataSourceImplMock)
            .login(any())
    }

    // -----------END HELPER METHODS----------

}