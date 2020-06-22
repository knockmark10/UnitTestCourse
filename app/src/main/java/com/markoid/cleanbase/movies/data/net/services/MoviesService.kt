package com.markoid.cleanbase.movies.data.net.services

import com.markoid.cleanbase.movies.data.net.entities.FetchMoviesResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {

    @GET("/movies")
    fun fetchMoviesByCategory(
        @Query("category") category: String
    ): Observable<Response<FetchMoviesResponse>>

}