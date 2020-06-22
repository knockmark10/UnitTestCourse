package com.markoid.core.data.repository.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import io.reactivex.annotations.NonNull

@Entity(tableName = "movies_table")
data class MoviesEntity(

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "code")
    val code: String,

    @NonNull
    @ColumnInfo(name = "name")
    val name: String,

    @NonNull
    @ColumnInfo(name = "duration")
    val duration: String,

    @NonNull
    @ColumnInfo(name = "rating")
    val rating: String,

    @NonNull
    @ColumnInfo(name = "synopsis")
    val synopsis: String,

    @NonNull
    @ColumnInfo(name = "category")
    val category: String

)