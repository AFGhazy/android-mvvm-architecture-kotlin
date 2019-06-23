package com.afghazy.framework.mvvm.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.afghazy.framework.mvvm.ui.base.BaseViewModel
import com.afghazy.framework.mvvm.utils.rx.AppSchedulerProvider
import com.afghazy.framework.mvvm.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
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

    fun onGoogleLoginClick() {

    }

    fun onFbLoginClick() {

    }

    fun onServerLoginClick() {

    }

    class Factory @Inject constructor(val loginInteractor: LoginInteractor,
                                      val schedulerProvider: AppSchedulerProvider,
                                      val compositeDisposable: CompositeDisposable) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return LoginViewModel(loginInteractor, schedulerProvider, compositeDisposable) as T
        }
    }
}