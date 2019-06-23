package com.afghazy.framework.mvvm.ui.feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.afghazy.framework.mvvm.ui.base.BaseInteractor
import com.afghazy.framework.mvvm.ui.base.BaseViewModel
import com.afghazy.framework.mvvm.utils.rx.AppSchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


/**
 * Created by Ahmed Fathy Ghazy on 2019-06-17
 * email ahmedfathyghazy@gmail.com
 * find me at https://github.com/afghazy
 */
 
class FeedViewModel(interactor: FeedInteractor, schedulerProvider: AppSchedulerProvider,
                    compositeDisposable: CompositeDisposable) :
    BaseViewModel<Any, FeedInteractor>(interactor, schedulerProvider, compositeDisposable) {

    class Factory @Inject constructor(val feedInteractor: FeedInteractor,
                                      val schedulerProvider: AppSchedulerProvider,
                                      val compositeDisposable: CompositeDisposable) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return FeedViewModel(feedInteractor, schedulerProvider, compositeDisposable) as T
        }
    }

}