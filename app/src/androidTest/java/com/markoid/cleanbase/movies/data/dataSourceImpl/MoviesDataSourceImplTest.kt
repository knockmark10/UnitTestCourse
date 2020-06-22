package com.markoid.cleanbase.movies.data.dataSourceImpl

import android.content.Context
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.markoid.cleanbase.movies.data.entities.testing.MoviesTestData
import com.markoid.cleanbase.movies.data.net.entities.FetchMoviesResponse
import com.markoid.cleanbase.movies.data.net.services.MoviesService
import com.markoid.core.data.net.handler.ApiResponseHandler
import com.markoid.core.data.repository.AppDatabase
import com.markoid.core.data.repository.dao.MoviesDao
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class MoviesDataSourceImplTest {

    // ---------START CONSTANTS--------------

    // -----------END CONSTANTS--------------

    // -----------START HELPER---------------

    @MockK
    lateinit var mApiResponseHandlerMock: ApiResponseHandler

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

    private lateinit var SUT: MoviesDataSourceImpl

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        this.mMoviesServiceTd = MoviesServiceTd()
        this.SUT = MoviesDataSourceImpl(
            this.mMoviesServiceTd,
            this.mMoviesDao,
            this.mApiResponseHandlerMock
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
    fun retrieveMoviesFromDb_repeatedItem_mustReturnsSingleItem() {
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
        result.assertValue { it.isEmpty() }
    }

    private inner class MoviesServiceTd : MoviesService {

        override fun fetchMoviesByCategory(category: String): Observable<Response<FetchMoviesResponse>> {
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

    // -----------END HELPER METHODS----------

}