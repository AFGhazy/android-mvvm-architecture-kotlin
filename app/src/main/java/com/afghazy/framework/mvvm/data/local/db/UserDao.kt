package com.afghazy.framework.mvvm.data.local.db

import androidx.room.*
import com.afghazy.framework.mvvm.data.model.db.User
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
    fun findByName(name: String): Single<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User): Single<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<User>): Single<List<Long>>

    @Query("SELECT * FROM users")
    fun loadAll(): Single<List<User>>

    @Query("SELECT * FROM users WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: List<Int>): Single<List<User>>
}