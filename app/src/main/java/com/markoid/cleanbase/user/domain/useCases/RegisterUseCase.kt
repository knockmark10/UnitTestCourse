package com.markoid.cleanbase.user.domain.useCases

import com.markoid.cleanbase.user.data.entities.RegisterScheme
import com.markoid.cleanbase.user.domain.repositoryAbstraction.UserRepository
import com.markoid.core.domain.executors.PostExecutionThread
import com.markoid.core.domain.executors.ThreadExecutor
import com.markoid.core.domain.useCases.UseCase
import io.reactivex.Observable
import javax.inject.Inject

class RegisterUseCase
@Inject constructor(
    private val userRepository: UserRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : UseCase<Unit, RegisterScheme>(threadExecutor, postExecutionThread) {

    override fun createObservable(params: RegisterScheme): Observable<Unit> = TODO()

}