package com.markoid.cleanbase.movies.data.net.entities

import com.google.gson.annotations.SerializedName
import com.markoid.core.data.net.entities.BaseResponse

data class FetchMoviesResponse(
    @SerializedName("movies")
    private val _movies: List<MoviesItem>? = null
) : BaseResponse() {
    val movies: List<MoviesItem>
        get() = _movies ?: emptyList()
}