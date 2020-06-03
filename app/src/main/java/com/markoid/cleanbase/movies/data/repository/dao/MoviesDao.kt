package com.markoid.cleanbase.movies.data.repository.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.markoid.cleanbase.movies.data.repository.entities.MoviesEntity

@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMovies(movies: MoviesEntity)

    @Query("SELECT * FROM movies_table")
    fun getMovies(): List<MoviesEntity>

}