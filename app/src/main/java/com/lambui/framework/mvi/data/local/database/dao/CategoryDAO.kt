package com.lambui.framework.mvi.data.local.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.lambui.framework.mvi.data.model.Category

@Dao
interface CategoryDAO {
    @Query("SELECT * FROM table_high_level ")
    suspend fun getCategoryAll() : List<Category>

}