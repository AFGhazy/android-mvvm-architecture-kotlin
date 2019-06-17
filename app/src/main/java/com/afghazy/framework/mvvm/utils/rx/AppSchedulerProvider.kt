package com.afghazy.framework.mvvm.utils.rx

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject


class AppSchedulerProvider @Inject constructor() : SchedulerProvider {
    override val computation: Scheduler
        get() = Schedulers.computation()
    override val io: Scheduler
        get() = Schedulers.io()
    override val ui: Scheduler
        get() = AndroidSchedulers.mainThread()
}