package com.afghazy.framework.mvvm.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.afghazy.framework.mvvm.data.local.db.dao.OptionDao
import com.afghazy.framework.mvvm.data.local.db.dao.QuestionDao
import com.afghazy.framework.mvvm.data.local.db.dao.UserDao
import com.afghazy.framework.mvvm.data.model.db.Option
import com.afghazy.framework.mvvm.data.model.db.Question
import com.afghazy.framework.mvvm.data.model.db.User


/**
 * Created by Ahmed Fathy Ghazy on 2019-06-16
 * email ahmedfathyghazy@gmail.com
 * find me at https://github.com/afghazy
 */

@Database(entities = [User::class, Question::class, Option::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun optionDao(): OptionDao

    abstract fun questionDao(): QuestionDao

    abstract fun userDao(): UserDao

}