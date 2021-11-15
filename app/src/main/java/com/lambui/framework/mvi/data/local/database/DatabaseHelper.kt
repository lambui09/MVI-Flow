package com.lambui.framework.mvi.data.local.database

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.lambui.framework.mvi.data.local.database.dao.CategoryDAO
import com.lambui.framework.mvi.data.model.Category
import com.lambui.framework.mvi.data.model.LowCategory
import java.io.File
import java.io.IOException

@Database(
    version = 1,
    entities = [Category::class, LowCategory::class]
)
abstract class DatabaseHelper : RoomDatabase() {
    private var INSTANCE: RoomDatabase? = null
    abstract fun createCategoryDao(): CategoryDAO
    fun getDatabase(ctx: Context): RoomDatabase {
        INSTANCE?.let { return it } ?: synchronized(RoomDatabase::class.java) {
            //read database
            if (!ctx.applicationContext.getDatabasePath(DATABASE_NAME).exists()) {
                val source = ctx.assets.open(DATABASE_ASSERT_NAME).use {
                    it.readBytes()
                }
            //write to database
                with(ctx.getDatabasePath(DATABASE_NAME)) {
                    val folder = path.substringBeforeLast(File.separator)
                    File(folder).mkdirs()
                    writeBytes(source)
                }
            }
            val instance = Room.databaseBuilder(ctx.applicationContext,DatabaseHelper::class.java,
                DATABASE_NAME).build()
            INSTANCE = instance
            return instance
        }
    }

    companion object {
        const val DATABASE_ASSERT_NAME = "final_db.db"
        const val DATABASE_NAME = "database.db"
    }
}