package com.afghazy.framework.mvvm.ui.splash

import android.content.Context
import com.afghazy.framework.mvvm.data.local.db.AppDatabase
import com.afghazy.framework.mvvm.data.local.prefs.PrefHelper
import com.afghazy.framework.mvvm.data.model.local.LoggedInMode
import com.afghazy.framework.mvvm.data.model.local.Option
import com.afghazy.framework.mvvm.data.model.local.Question
import com.afghazy.framework.mvvm.ui.base.BaseInteractor
import com.afghazy.framework.mvvm.utils.SEED_DATABASE_OPTIONS
import com.afghazy.framework.mvvm.utils.SEED_DATABASE_QUESTIONS
import com.afghazy.framework.mvvm.utils.loadJSONFromAsset
import com.google.gson.Gson
import io.reactivex.Observable
import javax.inject.Inject
import com.google.gson.internal.`$Gson$Types`
import io.reactivex.Completable


/**
 * Created by Ahmed Fathy Ghazy on 2019-06-23
 * email ahmedfathyghazy@gmail.com
 * find me at https://github.com/afghazy
 */

// extends all the data providers (Api and Local (db and pref))
class SplashInteractor @Inject constructor(
    val context: Context,
    val appDatabase: AppDatabase,
    val prefHelper: PrefHelper,
    val gson: Gson
) : BaseInteractor {
    fun seedQuestions(): Completable =
        allQuestions.first(emptyList()).flatMapCompletable {
            if(it.isEmpty()) insertQuestions(allAssetsQuestions)
            else Completable.complete()
        }

    fun seedOptions(): Completable =
        allOptions.first(emptyList()).flatMapCompletable {
            if(it.isEmpty()) insertOptions(allAssetsOptions)
            else Completable.complete()
        }

    val allAssetsQuestions: List<Question> = with(`$Gson$Types`.newParameterizedTypeWithOwner(null, List::class.java, Question::class.java)) {
        gson.fromJson<List<Question>>(loadJSONFromAsset(context, SEED_DATABASE_QUESTIONS), this)
    }

    val allAssetsOptions: List<Option> = with(`$Gson$Types`.newParameterizedTypeWithOwner(null, List::class.java, Option::class.java)) {
        gson.fromJson<List<Option>>(loadJSONFromAsset(context, SEED_DATABASE_OPTIONS), this)
    }

    val allQuestions: Observable<List<Question>>
        get() = appDatabase.questionDao().loadAll()

    val allOptions: Observable<List<Option>>
        get() = appDatabase.optionDao().loadAll()

    fun insertQuestions(qu: List<Question>) = appDatabase.questionDao().insertAll(qu)

    fun insertOptions(op: List<Option>) = appDatabase.optionDao().insertAll(op)

    var loggedInMode: LoggedInMode
        get() = prefHelper.currentUserLoggedInMode
        set(value) { prefHelper.currentUserLoggedInMode = value }

}