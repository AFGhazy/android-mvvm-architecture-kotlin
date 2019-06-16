package com.afghazy.framework.mvvm.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.afghazy.framework.mvvm.data.model.db.Option
import io.reactivex.Observable
import io.reactivex.Single


/**
 * Created by Ahmed Fathy Ghazy on 2019-06-16
 * email ahmedfathyghazy@gmail.com
 * find me at https://github.com/afghazy
 */

@Dao
interface OptionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(option: Option): Observable<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(options: List<Option>): Observable<List<Long>>

    @Query("SELECT * FROM options")
    fun loadAll(): Observable<List<Option>>

    @Query("SELECT * FROM options WHERE question_id = :questionId")
    fun loadAllByQuestionId(questionId: Long?): Observable<List<Option>>
}