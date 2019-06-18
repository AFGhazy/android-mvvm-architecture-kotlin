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
import java.lang.reflect.Type

// extends all the data providers (Api and Local (db and pref))
class AppDataManager @Inject constructor(
    val context: Context,
    val appDatabase: AppDatabase,
    val prefHelper: PrefHelper,
    val gson: Gson
) : DataManager {
    override fun seedDatabaseOptions(): Observable<Boolean> {
        return appDatabase.optionDao().loadAll()
            .concatMap { all ->
                println(all)
                if (all.isEmpty()) {
                    val type: Type =
                        `$Gson$Types`.newParameterizedTypeWithOwner(null, List::class.java, Option::class.java)
                    val optionL =
                        gson.fromJson<List<Option>>(loadJSONFromAsset(context, SEED_DATABASE_OPTIONS), type)
                    println(optionL)
                    appDatabase.optionDao().insertAll(optionL)
                }
                Observable.just(true)
            }
    }

    override fun seedDatabaseQuestions(): Observable<Boolean> {
        return appDatabase.optionDao().loadAll()
            .concatMap { all ->
                if (all.isEmpty()) {
                    val type: Type =
                        `$Gson$Types`.newParameterizedTypeWithOwner(null, List::class.java, Question::class.java)
                    val questionL =
                        gson.fromJson<List<Question>>(loadJSONFromAsset(context, SEED_DATABASE_QUESTIONS), type)
                    appDatabase.questionDao().insertAll(questionL)
                }
                Observable.just(true)
            }
    }

}