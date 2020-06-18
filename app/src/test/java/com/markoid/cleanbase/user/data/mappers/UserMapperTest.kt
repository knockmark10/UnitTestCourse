package com.markoid.cleanbase.user.data.mappers

import org.junit.Before
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

    // -----------START HELPER METHODS--------

    // -----------END HELPER METHODS----------

}