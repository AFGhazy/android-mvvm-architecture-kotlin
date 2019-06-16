package com.afghazy.framework.mvvm.data.local.prefs


/**
 * Created by Ahmed Fathy Ghazy on 2019-06-16
 * email ahmedfathyghazy@gmail.com
 * find me at https://github.com/afghazy
 */

interface PrefHelper {
    var accessToken: String
    var currentUserEmail: String
    var currentUserId: Long
    var currentUserLoggedInMode: Int
    var currentUserName: String
    var currentUserProfilePicUrl: String
}