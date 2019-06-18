package com.afghazy.framework.mvvm.data.manager

import io.reactivex.Observable

interface DataManager {

    fun seedDatabaseQuestions(): Observable<Boolean>

    fun seedDatabaseOptions(): Observable<Boolean>

}