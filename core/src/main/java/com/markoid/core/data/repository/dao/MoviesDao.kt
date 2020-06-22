package com.markoid.core.data.repository.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.markoid.core.data.repository.entities.MoviesEntity

@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMovie(movie: MoviesEntity)

    @Query("SELECT * FROM movies_table WHERE category = :category")
    fun getMoviesByCategory(category: String): List<MoviesEntity>

}