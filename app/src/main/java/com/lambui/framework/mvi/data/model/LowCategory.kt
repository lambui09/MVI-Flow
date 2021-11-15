package com.lambui.framework.mvi.data.model

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "table_low_level")
data class LowCategory(
    val lowLevel: String? = null,
    val highLevel: String? = null
) : Parcelable
