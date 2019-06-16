package com.afghazy.framework.mvvm.data.model.api.blog

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
data class Blog(

    @Expose
    @SerializedName("author")
    val author: String,

    @Expose
    @SerializedName("blog_url")
    private val blogUrl: String,

    @Expose
    @SerializedName("img_url")
    val coverImgUrl: String,

    @Expose
    @SerializedName("published_at")
    val date: String,

    @Expose
    @SerializedName("description")
    val description: String,

    @Expose
    @SerializedName("title")
    val title: String
) : Parcelable