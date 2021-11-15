package com.lambui.framework.mvi.data.repository

import androidx.room.Dao
import com.lambui.framework.mvi.data.api.ApiHelper
import com.lambui.framework.mvi.data.local.database.dao.CategoryDAO


class MainRepository(private val apiHelper: ApiHelper, private val categoryDAO: CategoryDAO) {

    suspend fun getUsers() = apiHelper.getUsers()
    suspend fun getVocabulary() = categoryDAO.getCategoryAll()

}