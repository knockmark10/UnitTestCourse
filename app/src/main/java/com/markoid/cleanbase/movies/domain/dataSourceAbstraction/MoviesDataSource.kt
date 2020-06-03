package com.markoid.cleanbase.movies.domain.dataSourceAbstraction

import com.markoid.cleanbase.movies.data.net.entities.FetchMoviesResponse
import com.markoid.cleanbase.movies.data.net.entities.MoviesItem
import com.markoid.cleanbase.movies.data.repository.entities.MoviesEntity
import io.reactivex.Observable

interface MoviesDataSource {
    fun fetchMoviesFromServer(): Observable<FetchMoviesResponse>
    fun retrieveMoviesFromDb(): Observable<List<MoviesEntity>>
    fun saveMoviesIntoDb(movies: List<MoviesItem>): Observable<Unit>
}