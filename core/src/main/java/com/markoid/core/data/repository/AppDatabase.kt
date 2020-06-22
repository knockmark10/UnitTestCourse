package com.markoid.core.data.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.markoid.core.data.repository.dao.MoviesDao
import com.markoid.core.data.repository.entities.MoviesEntity

@Database(entities = [MoviesEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getMoviesDao(): MoviesDao

}