package com.markoid.cleanbase.movies.data.entities.testing

import com.markoid.cleanbase.movies.data.net.entities.FetchMoviesResponse
import com.markoid.core.data.repository.entities.MoviesEntity
import retrofit2.Response

object MoviesTestData {

    val firstMovieItem: MoviesEntity
        get() = MoviesEntity(
            code = "a89dfgjdfg",
            name = "The Incredibles",
            duration = "109",
            rating = "4.5",
            synopsis = "Some synopsis",
            category = "action"
        )

    val secondMovieItem: MoviesEntity
        get() = MoviesEntity(
            code = "sdf8j324ljk34",
            name = "Taken",
            duration = "143",
            rating = "5",
            synopsis = "Some synopsis",
            category = "action"
        )

    val successfulMoviesResponse: Response<FetchMoviesResponse>
        get() = Response.success(FetchMoviesResponse())

}