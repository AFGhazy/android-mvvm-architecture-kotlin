package com.afghazy.framework.mvvm.ui.feed

import com.afghazy.framework.mvvm.ui.base.BaseInteractor
import com.afghazy.framework.mvvm.ui.base.BaseViewModel
import com.afghazy.framework.mvvm.utils.rx.AppSchedulerProvider
import io.reactivex.disposables.CompositeDisposable


/**
 * Created by Ahmed Fathy Ghazy on 2019-06-17
 * email ahmedfathyghazy@gmail.com
 * find me at https://github.com/afghazy
 */
 
class FeedViewModel(interactor: FeedInteractor, schedulerProvider: AppSchedulerProvider,
                    compositeDisposable: CompositeDisposable) :
    BaseViewModel<Any, FeedInteractor>(interactor, schedulerProvider, compositeDisposable) {

}