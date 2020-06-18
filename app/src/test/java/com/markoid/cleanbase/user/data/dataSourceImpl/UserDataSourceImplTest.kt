package com.markoid.cleanbase.user.data.dataSourceImpl

import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UserDataSourceImplTest {

    // ---------START CONSTANTS--------------

    // -----------END CONSTANTS--------------

    // -----------START HELPER---------------

    // -----------END HELPER-----------------

    private lateinit var SUT: UserDataSourceImpl

    @Before
    fun setup() {
        this.SUT = UserDataSourceImpl()
    }

    //login - request passed to endpoint
    //login - response handled correctly

    // -----------START HELPER METHODS--------

    // -----------END HELPER METHODS----------

}