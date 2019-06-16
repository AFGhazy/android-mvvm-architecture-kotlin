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
data class LoginResponse(
    @Expose
    @SerializedName("access_token")
    val accessToken: String,

    @Expose
    @SerializedName("fb_profile_pic_url")
    val fbProfilePicUrl: String,

    @Expose
    @SerializedName("google_profile_pic_url")
    val googleProfilePicUrl: String,

    @Expose
    @SerializedName("server_profile_pic_url")
    val serverProfilePicUrl: String,

    @Expose
    @SerializedName("message")
    val message: String,

    @Expose
    @SerializedName("status_code")
    val statusCode: String,

    @Expose
    @SerializedName("email")
    val userEmail: String,

    @Expose
    @SerializedName("user_id")
    val userId: Long,

    @Expose
    @SerializedName("user_name")
    val userName: String
) : Parcelable