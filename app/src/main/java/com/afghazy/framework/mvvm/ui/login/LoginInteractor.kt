package com.afghazy.framework.mvvm.ui.login

import android.content.Context
import com.afghazy.framework.mvvm.data.local.db.AppDatabase
import com.afghazy.framework.mvvm.data.local.prefs.PrefHelper
import com.afghazy.framework.mvvm.ui.base.BaseInteractor
import javax.inject.Inject


/**
 * Created by Ahmed Fathy Ghazy on 2019-06-23
 * email ahmedfathyghazy@gmail.com
 * find me at https://github.com/afghazy
 */
 
class LoginInteractor @Inject constructor(
    val context: Context,
    val appDatabase: AppDatabase,
    val prefHelper: PrefHelper
    ) : BaseInteractor {

}