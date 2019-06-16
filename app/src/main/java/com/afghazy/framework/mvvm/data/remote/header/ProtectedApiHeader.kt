package com.afghazy.framework.mvvm.data.remote.header

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


/**
 * Created by Ahmed Fathy Ghazy on 2019-06-16
 * email ahmedfathyghazy@gmail.com
 * find me at https://github.com/afghazy
 */

@Parcelize
data class ProtectedApiHeader (
    @Expose
    @SerializedName("access_token")
    private val mAccessToken: String,

    @Expose
    @SerializedName("api_key")
    private val mApiKey: String,

    @Expose
    @SerializedName("user_id")
    private val mUserId: Long
) : Parcelable