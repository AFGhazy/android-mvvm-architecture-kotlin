package com.afghazy.framework.mvvm.data.model.db

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*


@Parcelize
@Entity(tableName = "users")
data class User(
    @PrimaryKey
    val id: Long,

    @ColumnInfo(name = "created_at")
    val createdAt: String? = Date().toString(),

    @ColumnInfo(name = "updated_at")
    val updatedAt: String? = Date().toString(),

    val name: String
) : Parcelable