package com.afghazy.framework.mvvm.data.manager

import com.afghazy.framework.mvvm.data.model.db.Option
import com.afghazy.framework.mvvm.data.model.db.Question
import io.reactivex.Completable
import io.reactivex.Observable

interface DataManager {

    val allQuestions: Observable<List<Question>>

    val allOptions: Observable<List<Option>>

    fun insertQuestions(qu: List<Question>): Completable

    fun insertOptions(op: List<Option>): Completable

    val allAssetsQuestions: List<Question>

    val allAssetsOptions: List<Option>

    fun seedQuestions(): Completable

    fun seedOptions(): Completable

}