package com.markoid.cleanbase.movies.domain.useCases

import com.markoid.cleanbase.movies.data.entities.schemes.MoviesScheme
import com.markoid.core.domain.executors.PostExecutionThread
import com.markoid.core.domain.executors.ThreadExecutor
import com.markoid.core.domain.useCases.UseCase
import io.reactivex.Observable
import javax.inject.Inject

class GetMoviesUseCase
@Inject constructor(
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : UseCase<List<MoviesScheme>, String>(threadExecutor, postExecutionThread) {

    override fun createObservable(params: String): Observable<List<MoviesScheme>> = TODO()

}