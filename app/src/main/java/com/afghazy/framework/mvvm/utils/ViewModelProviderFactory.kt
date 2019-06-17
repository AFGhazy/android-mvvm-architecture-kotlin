package com.afghazy.framework.mvvm.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.afghazy.framework.mvvm.data.manager.DataManager
import com.afghazy.framework.mvvm.ui.feed.FeedViewModel
import com.afghazy.framework.mvvm.utils.rx.AppSchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


/**
 * Created by Ahmed Fathy Ghazy on 2019-06-17
 * email ahmedfathyghazy@gmail.com
 * find me at https://github.com/afghazy
 */

class ViewModelProviderFactory @Inject constructor(
    val dataManager: DataManager,
    val schedulerProvider: AppSchedulerProvider,
    val compositeDisposable: CompositeDisposable) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(FeedViewModel::class.java)) {
            FeedViewModel(dataManager, schedulerProvider, compositeDisposable) as T
        }
        else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}