package com.markoid.cleanbase.user.data.mappers

import com.markoid.cleanbase.user.data.entities.testing.UserTestData
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UserMapperTest {

    // ---------START CONSTANTS--------------

    // -----------END CONSTANTS--------------

    // -----------START HELPER---------------

    // -----------END HELPER-----------------

    private lateinit var SUT: UserMapper

    @Before
    fun setup() {
        this.SUT = UserMapper()
    }

    //mapLoginSchemeToLoginRequest - mapped object has same properties as returned object
    @Test
    fun mapLoginSchemeToLoginRequest_mappedObjectHasSamePropertiesAsReturnedObject() {
        // Arrange
        // Act
        val result = this.SUT.mapLoginSchemeToLoginRequest(UserTestData.correctLoginScheme)
        // Assert
        assertThat(result.email, `is`(UserTestData.correctLoginScheme.email))
        assertThat(result.password, `is`(UserTestData.correctLoginScheme.password))
    }
    // -----------START HELPER METHODS--------

    // -----------END HELPER METHODS----------

}