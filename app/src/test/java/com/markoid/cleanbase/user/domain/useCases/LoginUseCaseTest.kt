package com.markoid.cleanbase.user.domain.useCases

import com.markoid.cleanbase.user.data.entities.testing.UserTestData
import com.markoid.cleanbase.user.domain.exceptions.SignInException
import com.markoid.cleanbase.user.domain.repositoryAbstraction.UserRepository
import com.markoid.cleanbase.user.presentation.managers.EmailValidator
import com.markoid.core.domain.executors.PostExecutionThread
import com.markoid.core.domain.executors.ThreadExecutor
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LoginUseCaseTest {

    // ---------START CONSTANTS--------------

    // -----------END CONSTANTS--------------

    // -----------START HELPER---------------
    @Mock
    lateinit var mEmailValidatorMock: EmailValidator

    @Mock
    lateinit var mUserRepositoryMock: UserRepository

    @Mock
    lateinit var mThreadExecutorMock: ThreadExecutor

    @Mock
    lateinit var mPostExecutionThreadMock: PostExecutionThread

    // -----------END HELPER-----------------

    private lateinit var SUT: LoginUseCase

    @Before
    fun setup() {
        this.SUT = LoginUseCase(
            this.mEmailValidatorMock,
            this.mUserRepositoryMock,
            this.mThreadExecutorMock,
            this.mPostExecutionThreadMock
        )
    }

    //no errors found
    @Test
    fun createObservable_noErrorsFound() {
        // Arrange
        // Act
        val result = this.SUT.createObservable(UserTestData.correctLoginScheme).test()
        // Assert
        result.assertNoErrors()
    }

    //empty user - user error returned
    @Test
    fun createObservable_emptyUser_userErrorReturned() {
        // Arrange
        // Act
        val result =
            this.SUT.createObservable(UserTestData.emptyUserLoginScheme).test()
        // Assert
        result.assertError {
            if (it is SignInException) {
                it.type == SignInException.Type.USER_ERROR
            } else {
                false
            }
        }
    }

    //invalid user - invalid format error returned
    @Test
    fun createObservable_invalidUser_invalidFormatErrorReturned() {
        // Arrange
        // Act
        val result =
            this.SUT.createObservable(UserTestData.invalidUserLoginScheme).test()
        // Assert
        result.assertError {
            if (it is SignInException) {
                it.type == SignInException.Type.INVALID_FORMAT_ERROR
            } else {
                false
            }
        }
    }

    //empty password - password error returned
    //all data correct - data passed to endpoint

    // -----------START HELPER METHODS--------

    // -----------END HELPER METHODS----------

}