package com.afghazy.framework.mvvm.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.afghazy.framework.mvvm.data.model.local.LoggedInMode
import com.afghazy.framework.mvvm.ui.base.BaseViewModel
import com.afghazy.framework.mvvm.utils.rx.AppSchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by Ahmed Fathy Ghazy on 2019-06-18
 * email ahmedfathyghazy@gmail.com
 * find me at https://github.com/afghazy
 */

class SplashViewModel(interactor: SplashInteractor,
                      schedulerProvider: AppSchedulerProvider,
                      compositeDisposable: CompositeDisposable) :
    BaseViewModel<SplashNavigator, SplashInteractor>(interactor, schedulerProvider, compositeDisposable) {

    fun startSeeding() {

        compositeDisposable.add(
            interactor.seedQuestions()
                .andThen(interactor.seedOptions())
                .subscribeOn(schedulerProvider.io)
                .observeOn(schedulerProvider.ui)
                .doOnComplete {
                    when(interactor.loggedInMode) {
                        LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT -> navigator?.openLogin()
                        else -> navigator?.openMain()
                    }
                }
                .subscribe()
        )
    }

    class Factory @Inject constructor(val splashInteractor: SplashInteractor,
                  val schedulerProvider: AppSchedulerProvider,
                  val compositeDisposable: CompositeDisposable) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return SplashViewModel(splashInteractor, schedulerProvider, compositeDisposable) as T
        }
    }

}