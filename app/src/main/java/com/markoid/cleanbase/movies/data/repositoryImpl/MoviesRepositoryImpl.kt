package com.markoid.cleanbase.movies.data.repositoryImpl

import com.markoid.cleanbase.movies.data.dataSourceImpl.MoviesDataSourceImpl
import com.markoid.cleanbase.movies.data.entities.MoviesScheme
import com.markoid.cleanbase.movies.data.mappers.MoviesMapper
import com.markoid.cleanbase.movies.domain.repositoryAbstraction.MoviesRepository
import io.reactivex.Observable
import javax.inject.Inject

class MoviesRepositoryImpl
@Inject constructor(
    private val moviesDataSourceImpl: MoviesDataSourceImpl,
    private val moviesMapper: MoviesMapper
) : MoviesRepository {

    override fun getMovies(): Observable<List<MoviesScheme>> = TODO()

}