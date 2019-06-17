package com.afghazy.framework.mvvm.data.local.prefs

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by Ahmed Fathy Ghazy on 2019-06-16
 * email ahmedfathyghazy@gmail.com
 * find me at https://github.com/afghazy
 */

@Singleton
class AppPrefHelper @Inject constructor(val sharedPreferences: SharedPreferences) :
    PrefHelper {
    override var accessToken: String
        get() = sharedPreferences.getString(PREF_KEY_ACCESS_TOKEN, "") ?: ""
        set(value) { sharedPreferences.inTransaction { putString(PREF_KEY_ACCESS_TOKEN, value) } }

    override var currentUserEmail: String
        get() = sharedPreferences.getString(PREF_KEY_CURRENT_USER_EMAIL, "") ?: ""
        set(value) { sharedPreferences.inTransaction { putString(PREF_KEY_CURRENT_USER_EMAIL, value) } }

    override var currentUserId: Long
        get() = sharedPreferences.getLong(PREF_KEY_CURRENT_USER_ID, 0)
        set(value) { sharedPreferences.inTransaction { putLong(PREF_KEY_CURRENT_USER_ID, value) } }

    override var currentUserLoggedInMode: Int
        get() = sharedPreferences.getInt(PREF_KEY_USER_LOGGED_IN_MODE, 0)
        set(value) { sharedPreferences.inTransaction { putInt(PREF_KEY_USER_LOGGED_IN_MODE, value) } }

    override var currentUserName: String
        get() = sharedPreferences.getString(PREF_KEY_CURRENT_USER_NAME, "") ?: ""
        set(value) { sharedPreferences.inTransaction { putString(PREF_KEY_CURRENT_USER_NAME, value) } }

    override var currentUserProfilePicUrl: String
        get() = sharedPreferences.getString(PREF_KEY_CURRENT_USER_PROFILE_PIC_URL, "") ?: ""
        set(value) { sharedPreferences.inTransaction { putString(PREF_KEY_CURRENT_USER_PROFILE_PIC_URL, value) } }


    private inline fun SharedPreferences.inTransaction(func: SharedPreferences.Editor.() -> Unit) = with(this.edit()) {
        func()
        apply()
    }

    companion object {
        private const val PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"
        private const val PREF_KEY_CURRENT_USER_EMAIL = "PREF_KEY_CURRENT_USER_EMAIL"
        private const val PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID"
        private const val PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME"
        private const val PREF_KEY_CURRENT_USER_PROFILE_PIC_URL = "PREF_KEY_CURRENT_USER_PROFILE_PIC_URL"
        private const val PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE"
    }
}