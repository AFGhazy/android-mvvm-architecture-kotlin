package com.afghazy.framework.mvvm.ui.base

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import com.afghazy.framework.mvvm.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference

abstract class BaseViewModel<N,I : BaseInteractor>(
    val interactor: I,
    val schedulerProvider: SchedulerProvider,
    val compositeDisposable: CompositeDisposable
) : ViewModel() {
    val isLoading = ObservableBoolean()
    var _nav: WeakReference<N?>? = null

    fun setNavigator(nav: N?) {
        _nav = WeakReference(nav)
    }

    val navigator: N?
        get() = _nav?.get()

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

    fun setIsLoading(isLoading: Boolean) {
        this.isLoading.set(isLoading)
    }
}