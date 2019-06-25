package com.afghazy.framework.mvvm.app

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.net.NetworkInfo
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.afghazy.framework.mvvm.di.component.DaggerAppComponent
import com.afghazy.framework.mvvm.utils.rx.AppSchedulerProvider
import com.afghazy.framework.mvvm.utils.rx.SchedulerProvider
import com.cantrowitz.rxbroadcast.RxBroadcast
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork
import com.tapadoo.alerter.Alerter
import dagger.android.AndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.DispatchingAndroidInjector
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


class MvvmApp : Application(), HasActivityInjector {
    @Inject
    lateinit var schedulerProvider: SchedulerProvider
    @Inject
    lateinit var compositeDisposable: CompositeDisposable
    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
    @Inject
    lateinit var localBroadcastManager: LocalBroadcastManager

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)

        val dis = ReactiveNetwork
            .observeNetworkConnectivity(this)
            .subscribeOn(schedulerProvider.io)
            .observeOn(schedulerProvider.ui)
            .subscribe(
                { connectivity ->
                    localBroadcastManager.sendBroadcast(Intent(ACTION_CHANGE_NETWORK_STATE).apply {
                        putExtra(EXTRA_CHANGE_NETWORK_STATE, connectivity.state())
                    })
                },
                {
                    localBroadcastManager.sendBroadcast(Intent(ACTION_CHANGE_NETWORK_STATE).apply {
                        putExtra(EXTRA_CHANGE_NETWORK_STATE, NetworkInfo.State.DISCONNECTED)
                    })
                }
            )

        compositeDisposable.add(dis)
    }

    companion object {
        const val ACTION_CHANGE_NETWORK_STATE = "CHANGE_NETWORK_STATE_ACTION"
        const val EXTRA_CHANGE_NETWORK_STATE = "EXTRA_CHANGE_NETWORK_STATE"
    }
}