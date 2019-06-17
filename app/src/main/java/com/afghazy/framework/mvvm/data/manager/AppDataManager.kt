package com.afghazy.framework.mvvm.data.manager

import android.content.Context
import com.afghazy.framework.mvvm.data.local.db.AppDatabase
import com.afghazy.framework.mvvm.data.local.prefs.PrefHelper
import com.google.gson.Gson
import javax.inject.Inject

// extends all the data providers (Api and Local (db and pref))
class AppDataManager @Inject constructor(val context: Context,
                                         val appDatabase: AppDatabase,
                                         val prefHelper: PrefHelper,
                                         val gson: Gson) : DataManager {

}