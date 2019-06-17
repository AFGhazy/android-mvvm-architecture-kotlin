package com.afghazy.framework.mvvm.data.model.db

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(
    tableName = "questions"
)
data class Question(
    @Expose
    @PrimaryKey
    val id: Long,

    @Expose
    @SerializedName("created_at")
    @ColumnInfo(name = "created_at")
    val createdAt: String,

    @Expose
    @SerializedName("question_img_url")
    @ColumnInfo(name = "question_img_url")
    val imgUrl: String,

    @Expose
    @SerializedName("question_text")
    @ColumnInfo(name = "question_text")
    val questionText: String,

    @Expose
    @SerializedName("updated_at")
    @ColumnInfo(name = "updated_at")
    val updatedAt: String
) : Parcelable