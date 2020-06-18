package com.markoid.cleanbase.user.presentation.managers

import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class EmailValidatorTest {

    // ---------START CONSTANTS--------------

    // -----------END CONSTANTS--------------

    // -----------START HELPER---------------

    // -----------END HELPER-----------------

    private lateinit var SUT: EmailValidator

    @Before
    fun setup() {
        this.SUT = EmailValidator()
    }

    @Test
    fun isEmailValid_validEmail_mustReturnTrue() {
        // Arrange
        // Act
        val result = this.SUT.isEmailValid("mail@ia.com.mx")
        // Assert
        assertTrue(result)
    }

    @Test
    fun isEmailValid_invalidEmail_mustReturnFalse() {
        // Arrange
        // Act
        val result = this.SUT.isEmailValid("")
        // Assert
        assertFalse(result)
    }
    // -----------START HELPER METHODS--------

    // -----------END HELPER METHODS----------

}