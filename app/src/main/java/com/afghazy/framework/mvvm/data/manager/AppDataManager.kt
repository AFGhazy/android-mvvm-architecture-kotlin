package com.afghazy.framework.mvvm.data.manager

import android.content.Context
import com.afghazy.framework.mvvm.data.local.db.AppDatabase
import com.afghazy.framework.mvvm.data.local.prefs.PrefHelper
import com.afghazy.framework.mvvm.data.model.db.Option
import com.afghazy.framework.mvvm.data.model.db.Question
import com.afghazy.framework.mvvm.utils.SEED_DATABASE_OPTIONS
import com.afghazy.framework.mvvm.utils.SEED_DATABASE_QUESTIONS
import com.afghazy.framework.mvvm.utils.loadJSONFromAsset
import com.google.gson.Gson
import io.reactivex.Observable
import javax.inject.Inject
import com.google.gson.internal.`$Gson$Types`
import io.reactivex.Completable
import java.lang.reflect.Type

// extends all the data providers (Api and Local (db and pref))
class AppDataManager @Inject constructor(
    val context: Context,
    val appDatabase: AppDatabase,
    val prefHelper: PrefHelper,
    val gson: Gson
) : DataManager {
    override fun seedQuestions(): Completable =
        allQuestions.first(emptyList()).flatMapCompletable {
            if(it.isEmpty()) insertQuestions(allAssetsQuestions)
            else Completable.complete()
        }

    override fun seedOptions(): Completable =
        allOptions.first(emptyList()).flatMapCompletable {
            if(it.isEmpty()) insertOptions(allAssetsOptions)
            else Completable.complete()
        }

    override val allAssetsQuestions: List<Question> = with(`$Gson$Types`.newParameterizedTypeWithOwner(null, List::class.java, Question::class.java)) {
        gson.fromJson<List<Question>>(loadJSONFromAsset(context, SEED_DATABASE_QUESTIONS), this)
    }

    override val allAssetsOptions: List<Option> = with(`$Gson$Types`.newParameterizedTypeWithOwner(null, List::class.java, Option::class.java)) {
        gson.fromJson<List<Option>>(loadJSONFromAsset(context, SEED_DATABASE_OPTIONS), this)
    }

    override val allQuestions: Observable<List<Question>>
        get() = appDatabase.questionDao().loadAll()

    override val allOptions: Observable<List<Option>>
        get() = appDatabase.optionDao().loadAll()

    override fun insertQuestions(qu: List<Question>) = appDatabase.questionDao().insertAll(qu)

    override fun insertOptions(op: List<Option>) = appDatabase.optionDao().insertAll(op)

}