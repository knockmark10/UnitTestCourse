package com.markoid.cleanbase.user.domain.useCases

import android.util.Patterns
import org.junit.Assert.*

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

import org.hamcrest.CoreMatchers.*
import org.mockito.ArgumentMatchers.*
import org.mockito.ArgumentCaptor.*
import org.mockito.Mockito.*

@RunWith(MockitoJUnitRunner::class)
class LoginUseCaseTest {

    // ---------START CONSTANTS--------------

    // -----------END CONSTANTS--------------

    // -----------START HELPER---------------

    // -----------END HELPER-----------------

    private lateinit var SUT: LoginUseCase

    @Before
    fun setup() {
        this.SUT = LoginUseCase()
    }

    //no errors found
    //empty user - user error returned
    //invalid user - invalid format error returned
    //empty password - password error returned
    //all data correct - data passed to endpoint

    // -----------START HELPER METHODS--------

    // -----------END HELPER METHODS----------

}