package com.afghazy.framework.mvvm.data.model.local


/**
 * Created by Ahmed Fathy Ghazy on 2019-06-23
 * email ahmedfathyghazy@gmail.com
 * find me at https://github.com/afghazy
 */

enum class LoggedInMode(val value: Int) {
    LOGGED_IN_MODE_LOGGED_OUT(0),
    LOGGED_IN_MODE_GOOGLE(1),
    LOGGED_IN_MODE_FB(2),
    LOGGED_IN_MODE_SERVER(3);

    companion object {
        fun fromInt(value: Int): LoggedInMode {
            for (i in values()) if (i.value == value) return i
            return fromInt(0)
        }
    }
}