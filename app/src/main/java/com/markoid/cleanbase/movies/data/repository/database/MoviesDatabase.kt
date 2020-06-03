package com.markoid.cleanbase.movies.data.repository.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.markoid.cleanbase.movies.data.repository.dao.MoviesDao
import com.markoid.cleanbase.movies.data.repository.entities.MoviesEntity

@Database(entities = [MoviesEntity::class], version = 1, exportSchema = false)
abstract class MoviesDatabase : RoomDatabase() {

    abstract fun getMoviesDao(): MoviesDao

}