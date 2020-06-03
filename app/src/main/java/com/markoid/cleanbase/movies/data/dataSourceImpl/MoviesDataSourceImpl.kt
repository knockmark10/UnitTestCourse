package com.markoid.cleanbase.movies.data.dataSourceImpl

import com.markoid.cleanbase.movies.data.net.entities.FetchMoviesResponse
import com.markoid.cleanbase.movies.data.net.entities.MoviesItem
import com.markoid.cleanbase.movies.data.net.services.MoviesService
import com.markoid.cleanbase.movies.data.repository.dao.MoviesDao
import com.markoid.cleanbase.movies.data.repository.entities.MoviesEntity
import com.markoid.cleanbase.movies.domain.dataSourceAbstraction.MoviesDataSource
import io.reactivex.Observable
import javax.inject.Inject

class MoviesDataSourceImpl
@Inject constructor(
    private val service: MoviesService,
    private val dao: MoviesDao
) : MoviesDataSource {

    override fun fetchMoviesFromServer(): Observable<FetchMoviesResponse> = TODO()

    override fun retrieveMoviesFromDb(): Observable<List<MoviesEntity>> = TODO()

    override fun saveMoviesIntoDb(movies: List<MoviesItem>): Observable<Unit> = TODO()
}