package com.afghazy.framework.mvvm.data.model.api.login

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
data class GoogleLoginRequest(
    @Expose
    @SerializedName("google_user_id")
    val googleUserId: String,

    @Expose
    @SerializedName("google_id_token")
    val idToken: String
) : Parcelable