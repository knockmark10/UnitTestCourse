package com.markoid.cleanbase.movies.data.dataSourceImpl

import android.content.Context
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.markoid.cleanbase.movies.data.entities.testing.MoviesTestData
import com.markoid.cleanbase.movies.data.net.entities.FetchMoviesResponse
import com.markoid.cleanbase.movies.data.net.services.MoviesService
import com.markoid.core.data.net.entities.BaseResponse
import com.markoid.core.data.net.handler.ApiResponseHandler
import com.markoid.core.data.repository.AppDatabase
import com.markoid.core.data.repository.dao.MoviesDao
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class MoviesDataSourceImplTestSolved {

    // ---------START CONSTANTS--------------

    // -----------END CONSTANTS--------------

    // -----------START HELPER---------------

    @MockK
    lateinit var mApiResponseHandleMock: ApiResponseHandler

    private lateinit var mMoviesServiceTd: MoviesServiceTd

    private val mContext: Context by lazy { InstrumentationRegistry.getInstrumentation().context }

    private val mDatabase: AppDatabase by lazy {
        Room
            .inMemoryDatabaseBuilder(this.mContext, AppDatabase::class.java)
            .allowMainThreadQueries()
            .build()
    }

    private val mMoviesDao: MoviesDao by lazy { this.mDatabase.getMoviesDao() }

    // -----------END HELPER-----------------

    private lateinit var SUT: MoviesDataSourceImplSolved

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        this.mMoviesServiceTd = MoviesServiceTd()
        this.SUT = MoviesDataSourceImplSolved(
            this.mMoviesServiceTd,
            this.mMoviesDao,
            this.mApiResponseHandleMock
        )
    }

    @Test
    fun retrieveMoviesFromDb_recordsWithinDb_notEmptyListReturned() {
        // Arrange
        saveItemsIntoDb()
        // Act
        val result =
            this.SUT.retrieveMoviesFromDb(MoviesTestData.firstMovieItem.category).test()
        // Assert
        result.assertValue { it.size == 2 }
    }

    @Test
    fun retrieveMoviesFromDb_repeatedItems_mustReturnSingleItem() {
        // Arrange
        saveRepeatedIdsIntoDb()
        // Act
        val result =
            this.SUT.retrieveMoviesFromDb(MoviesTestData.firstMovieItem.category).test()
        // Assert
        result.assertValue { it.size == 1 }
    }

    @Test
    fun retrieveMoviesFromDb_emptyDatabase_emptyListReturned() {
        // Arrange
        // Act
        val result =
            this.SUT.retrieveMoviesFromDb(MoviesTestData.firstMovieItem.category).test()
        // Assert
        result.assertOf {
            it.assertNoErrors()
            it.values().isEmpty()
        }
    }

    @Test
    fun fetchMoviesFromServer_categoryPassedToEndpoint() {
        // Arrange
        returnsFetchMoviesResponse()
        // Act
        val result =
            this.SUT.fetchMoviesFromServer(MoviesTestData.firstMovieItem.category).test()
        // Assert
        result.assertValue {
            MoviesTestData.firstMovieItem.category == this.mMoviesServiceTd.category
        }
    }

    @Test
    fun fetchMoviesFromServer_responseHandledByApiHandler() {
        // Arrange
        returnsFetchMoviesResponse()
        // Act
        this.SUT.fetchMoviesFromServer(MoviesTestData.firstMovieItem.category).test()
        // Assert
        verify { mApiResponseHandleMock.handle<FetchMoviesResponse>(any()) }
    }

    private inner class MoviesServiceTd : MoviesService {

        var category: String = ""

        override fun fetchMoviesByCategory(category: String): Observable<Response<FetchMoviesResponse>> {
            this.category = category
            return Observable.just(MoviesTestData.successfulMoviesResponse)
        }

    }

    // -----------START HELPER METHODS--------

    private fun saveItemsIntoDb() {
        this.mMoviesDao.saveMovie(MoviesTestData.firstMovieItem)
        this.mMoviesDao.saveMovie(MoviesTestData.secondMovieItem)
    }

    private fun saveRepeatedIdsIntoDb() {
        this.mMoviesDao.saveMovie(MoviesTestData.firstMovieItem)
        this.mMoviesDao.saveMovie(MoviesTestData.firstMovieItem)
        this.mMoviesDao.saveMovie(MoviesTestData.firstMovieItem)
        this.mMoviesDao.saveMovie(MoviesTestData.firstMovieItem)
        this.mMoviesDao.saveMovie(MoviesTestData.firstMovieItem)
    }

    private fun returnsFetchMoviesResponse() {
        every { mApiResponseHandleMock.handle<FetchMoviesResponse>(any()) } returns Observable.just(
            FetchMoviesResponse()
        )
    }
    // -----------END HELPER METHODS----------

}