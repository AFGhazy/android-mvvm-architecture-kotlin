package com.afghazy.framework.mvvm.utils.rx

import io.reactivex.Scheduler

interface SchedulerProvider {
    val computation: Scheduler
    val io: Scheduler
    val ui: Scheduler
}