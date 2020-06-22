package com.markoid.cleanbase.movies.domain.dataSourceAbstraction

import com.markoid.cleanbase.movies.data.net.entities.FetchMoviesResponse
import com.markoid.core.data.repository.entities.MoviesEntity
import io.reactivex.Observable

interface MoviesDataSource {
    fun fetchMoviesFromServer(category: String): Observable<FetchMoviesResponse>
    fun retrieveMoviesFromDb(category: String): Observable<List<MoviesEntity>>
    fun saveMoviesIntoDb(movies: List<MoviesEntity>): Observable<Unit>
}