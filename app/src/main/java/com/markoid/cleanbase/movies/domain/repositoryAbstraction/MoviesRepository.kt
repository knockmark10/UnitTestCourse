package com.markoid.cleanbase.movies.domain.repositoryAbstraction

import com.markoid.cleanbase.movies.data.entities.schemes.MoviesScheme
import io.reactivex.Observable

interface MoviesRepository {
    fun getMovies(): Observable<List<MoviesScheme>>
}