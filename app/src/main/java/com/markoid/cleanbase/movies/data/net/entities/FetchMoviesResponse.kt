package com.markoid.cleanbase.movies.data.net.entities

import com.google.gson.annotations.SerializedName

data class FetchMoviesResponse(
    @SerializedName("movies")
    private val _movies: List<MoviesItem>? = null
) {
    val movies: List<MoviesItem>
        get() = _movies ?: emptyList()
}