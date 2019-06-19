package com.afghazy.framework.mvvm.data.model.db

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*


@Parcelize
@Entity(
    tableName = "questions"
)
data class Question(
    @Expose
    @PrimaryKey
    val id: Long,

    @Expose
    @SerializedName("question_img_url")
    @ColumnInfo(name = "question_img_url")
    val imgUrl: String?,

    @Expose
    @SerializedName("question_text")
    @ColumnInfo(name = "question_text")
    val questionText: String
) : Parcelable