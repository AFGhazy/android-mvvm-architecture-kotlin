package com.afghazy.framework.mvvm.ui.login

import android.content.Context
import com.afghazy.framework.mvvm.data.local.db.AppDatabase
import com.afghazy.framework.mvvm.data.local.prefs.PrefHelper
import com.afghazy.framework.mvvm.data.model.api.login.LoginResponse
import com.afghazy.framework.mvvm.data.model.api.login.ServerLoginRequest
import com.afghazy.framework.mvvm.data.model.local.LoggedInMode
import com.afghazy.framework.mvvm.data.remote.ApiHelper
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
    val prefHelper: PrefHelper,
    val apiHelper: ApiHelper
    ) : BaseInteractor {
    fun doServerLoginApiCall(email: String, password: String) =
        apiHelper.doServerLoginApiCall(ServerLoginRequest(email,password))

    fun updateUserInfo(response: LoginResponse) {
        prefHelper.accessToken = response.accessToken
        prefHelper.currentUserId = response.userId
        prefHelper.currentUserLoggedInMode = LoggedInMode.LOGGED_IN_MODE_SERVER
        prefHelper.currentUserName = response.userName
        prefHelper.currentUserEmail = response.userEmail
        prefHelper.currentUserProfilePicUrl = response.googleProfilePicUrl ?: ""
    }
}