package com.afghazy.framework.mvvm.data.model.db

import android.os.Parcelable
import androidx.room.*
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(
    tableName = "options",
    foreignKeys = [
        ForeignKey(
        entity = Question::class,
        parentColumns = ["id"],
        childColumns = ["question_id"]
    )],
    indices = [Index(value = ["question_id"], name = "question_id")]
)
data class Option(
    @Expose
    @PrimaryKey
    val id: Long,

    @Expose
    @SerializedName("created_at")
    @ColumnInfo(name = "created_at")
    val createdAt: String,

    @Expose
    @SerializedName("question_id")
    @ColumnInfo(name = "question_id")
    val questionId: String,

    @Expose
    @SerializedName("option_text")
    @ColumnInfo(name = "option_text")
    val optionText: String,

    @Expose
    @SerializedName("is_correct")
    @ColumnInfo(name = "is_correct")
    val isCorrect: Boolean,

    @Expose
    @SerializedName("updated_at")
    @ColumnInfo(name = "updated_at")
    val updatedAt: String
) : Parcelable