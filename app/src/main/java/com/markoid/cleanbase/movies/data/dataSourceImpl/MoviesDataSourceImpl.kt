package com.markoid.cleanbase.movies.data.dataSourceImpl

import com.markoid.cleanbase.movies.data.net.entities.FetchMoviesResponse
import com.markoid.cleanbase.movies.data.net.services.MoviesService
import com.markoid.cleanbase.movies.domain.dataSourceAbstraction.MoviesDataSource
import com.markoid.core.data.net.handler.ApiResponseHandler
import com.markoid.core.data.repository.dao.MoviesDao
import com.markoid.core.data.repository.entities.MoviesEntity
import io.reactivex.Observable
import javax.inject.Inject

class MoviesDataSourceImpl
@Inject constructor(
    private val service: MoviesService,
    private val dao: MoviesDao,
    private val apiHandler: ApiResponseHandler
) : MoviesDataSource {

    override fun fetchMoviesFromServer(category: String): Observable<FetchMoviesResponse> = TODO()

    override fun retrieveMoviesFromDb(category: String): Observable<List<MoviesEntity>> = TODO()

    override fun saveMoviesIntoDb(movies: List<MoviesEntity>): Observable<Unit> = TODO()


}