package com.markoid.cleanbase.movies.data.mappers

import com.markoid.cleanbase.movies.data.entities.MoviesScheme
import com.markoid.cleanbase.movies.data.net.entities.MoviesItem
import com.markoid.cleanbase.movies.data.repository.entities.MoviesEntity
import javax.inject.Inject

class MoviesMapper @Inject constructor() {

    fun mapResponseToEntity(movies: List<MoviesItem>): List<MoviesEntity> = TODO()

    fun mapEntityToScheme(movies: List<MoviesEntity>): List<MoviesScheme> = TODO()

}