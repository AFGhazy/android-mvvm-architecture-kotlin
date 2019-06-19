package com.afghazy.framework.mvvm.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.afghazy.framework.mvvm.data.model.db.Question
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single


/**
 * Created by Ahmed Fathy Ghazy on 2019-06-16
 * email ahmedfathyghazy@gmail.com
 * find me at https://github.com/afghazy
 */

@Dao
interface QuestionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(question: Question): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(questions: List<Question>): Completable

    @Query("SELECT * FROM questions")
    fun loadAll(): Observable<List<Question>>

}