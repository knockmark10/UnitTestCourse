package com.markoid.core.presentation.modules

import android.app.Application
import androidx.room.Room
import com.markoid.core.data.repository.AppDatabase
import com.markoid.core.presentation.utils.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule(private val databaseName: String) {

    @Provides
    @Singleton
    fun providesAppDatabase(application: Application): AppDatabase =
        Room.databaseBuilder(
            application.applicationContext,
            AppDatabase::class.java,
           this.databaseName
        )
            .fallbackToDestructiveMigration()
            .build()

}