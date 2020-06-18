package com.markoid.cleanbase.user.data.repositoryImpl

import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UserRepositoryImplTest {

    // ---------START CONSTANTS--------------

    // -----------END CONSTANTS--------------

    // -----------START HELPER---------------

    // -----------END HELPER-----------------

    private lateinit var SUT: UserRepositoryImpl

    @Before
    fun setup() {
        this.SUT = UserRepositoryImpl()
    }

    //no errors
    //request passed to mapper
    //mapped object passed to data source

    // -----------START HELPER METHODS--------

    // -----------END HELPER METHODS----------

}