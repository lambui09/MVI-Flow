package com.lambui.framework.mvi.data.model

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "table_high_level")
data class Category(
    val word : String,
    val type : String,
    val level : String,
    val spelling : String,
    val pronun : String,
    val meaning : String,
    val example : String,
    val link : String,
    val searched : String
): Parcelable