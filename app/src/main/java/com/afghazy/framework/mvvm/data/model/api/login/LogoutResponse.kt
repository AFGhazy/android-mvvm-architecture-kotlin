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
data class LogoutResponse(
    @Expose
    @SerializedName("message")
    val message: String,

    @Expose
    @SerializedName("status_code")
    val statusCode: String
) : Parcelable