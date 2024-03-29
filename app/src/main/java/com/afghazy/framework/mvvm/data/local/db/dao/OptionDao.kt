package com.afghazy.framework.mvvm.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.afghazy.framework.mvvm.data.model.local.Option
import io.reactivex.Completable
import io.reactivex.Observable


/**
 * Created by Ahmed Fathy Ghazy on 2019-06-16
 * email ahmedfathyghazy@gmail.com
 * find me at https://github.com/afghazy
 */

@Dao
interface OptionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(option: Option): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(options: List<Option>): Completable

    @Query("SELECT * FROM options")
    fun loadAll(): Observable<List<Option>>

    @Query("SELECT * FROM options WHERE question_id = :questionId")
    fun loadAllByQuestionId(questionId: Long?): Observable<List<Option>>
}