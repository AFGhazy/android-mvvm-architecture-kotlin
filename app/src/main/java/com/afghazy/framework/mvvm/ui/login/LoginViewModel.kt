package com.afghazy.framework.mvvm.ui.login

import android.text.TextUtils
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.afghazy.framework.mvvm.data.model.api.login.LoginResponse
import com.afghazy.framework.mvvm.data.model.api.login.ServerLoginRequest
import com.afghazy.framework.mvvm.ui.base.BaseViewModel
import com.afghazy.framework.mvvm.utils.isEmailValid
import com.afghazy.framework.mvvm.utils.rx.AppSchedulerProvider
import com.afghazy.framework.mvvm.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import java.util.regex.Pattern
import javax.inject.Inject


/**
 * Created by Ahmed Fathy Ghazy on 2019-06-23
 * email ahmedfathyghazy@gmail.com
 * find me at https://github.com/afghazy
 */

class LoginViewModel @Inject constructor(
    interactor: LoginInteractor,
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable
) : BaseViewModel<LoginNavigator, LoginInteractor>(interactor, schedulerProvider, compositeDisposable) {

    fun isEmailAndPasswordValid(email: String, password: String) =
        !TextUtils.isEmpty(email) && isEmailValid(email) && !TextUtils.isEmpty(password)


    fun onGoogleLoginClick() {

    }

    fun onFbLoginClick() {

    }

    fun onServerLoginClick() {
        navigator?.login()
    }

    fun login(email: String, password: String) {
        setIsLoading(true)
        compositeDisposable.add(interactor
            .doServerLoginApiCall(email, password)
            .doOnSuccess { response: LoginResponse? ->
                response?.let { interactor.updateUserInfo(it) }
            }
            .subscribeOn(schedulerProvider.io)
            .observeOn(schedulerProvider.ui)
            .subscribe { response: LoginResponse?, throwable ->
                setIsLoading(false)
                if(throwable != null) {
                    // handle error
                    return@subscribe
                }
                setIsLoading(false)
                navigator?.openMain()


                // handle error
            }
        )
    }

    class Factory @Inject constructor(
        val loginInteractor: LoginInteractor,
        val schedulerProvider: AppSchedulerProvider,
        val compositeDisposable: CompositeDisposable
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return LoginViewModel(loginInteractor, schedulerProvider, compositeDisposable) as T
        }
    }
}