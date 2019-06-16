package com.afghazy.framework.mvvm.data.local.db.dao

import androidx.room.*
import com.afghazy.framework.mvvm.data.model.db.User
import io.reactivex.Observable
import io.reactivex.Single


/**
 * Created by Ahmed Fathy Ghazy on 2019-06-16
 * email ahmedfathyghazy@gmail.com
 * find me at https://github.com/afghazy
 */

@Dao
interface UserDao {
    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM users WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): Observable<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User): Observable<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<User>): Observable<List<Long>>

    @Query("SELECT * FROM users")
    fun loadAll(): Observable<List<User>>

    @Query("SELECT * FROM users WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: List<Int>): Observable<List<User>>
}