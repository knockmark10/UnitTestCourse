package com.markoid.cleanbase.user.domain.useCases

import com.markoid.cleanbase.user.data.entities.schemes.LoginScheme
import com.markoid.cleanbase.user.domain.exceptions.SignInException
import com.markoid.cleanbase.user.domain.repositoryAbstraction.UserRepository
import com.markoid.cleanbase.user.presentation.managers.EmailValidator
import com.markoid.core.domain.executors.PostExecutionThread
import com.markoid.core.domain.executors.ThreadExecutor
import com.markoid.core.domain.useCases.UseCase
import io.reactivex.Observable
import javax.inject.Inject

class LoginUseCase
@Inject constructor(
    private val emailValidator: EmailValidator,
    private val repository: UserRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : UseCase<Unit, LoginScheme>(threadExecutor, postExecutionThread) {

    override fun createObservable(params: LoginScheme): Observable<Unit> = when {
        params.email.isEmpty() ->
            Observable.error(SignInException(SignInException.Type.USER_ERROR))
        !this.emailValidator.isEmailValid(params.email) ->
            Observable.error(SignInException(SignInException.Type.INVALID_FORMAT_ERROR))
        else -> Observable.just(Unit)
    }


}