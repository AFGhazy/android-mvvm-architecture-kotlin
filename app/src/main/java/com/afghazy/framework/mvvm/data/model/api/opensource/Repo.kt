package com.afghazy.framework.mvvm.data.model.api.opensource

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
data class Repo(
    @Expose
    @SerializedName("img_url")
    private val coverImgUrl: String,

    @Expose
    @SerializedName("description")
    private val description: String,

    @Expose
    @SerializedName("project_url")
    private val projectUrl: String,

    @Expose
    @SerializedName("title")
    private val title: String
) : Parcelable