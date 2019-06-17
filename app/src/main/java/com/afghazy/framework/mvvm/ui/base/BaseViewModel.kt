package com.afghazy.framework.mvvm.ui.base

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import com.afghazy.framework.mvvm.data.manager.DataManager
import com.afghazy.framework.mvvm.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference

abstract class BaseViewModel<N>(
    val dataManager: DataManager,
    val schedulerProvider: SchedulerProvider,
    val compositeDisposable: CompositeDisposable
) : ViewModel() {
    val isLoading = ObservableBoolean()
    var navigator: N? = null
    val nav: WeakReference<N?> = WeakReference(navigator)

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}