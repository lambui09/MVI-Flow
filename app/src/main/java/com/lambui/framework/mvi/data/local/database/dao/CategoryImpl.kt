package com.lambui.framework.mvi.data.local.database.dao

import com.lambui.framework.mvi.data.model.Category

class CategoryImpl(private val categoryDAO: CategoryDAO) : CategoryDAO {
    override suspend fun getCategoryAll(): List<Category> {
        return categoryDAO.getCategoryAll()
    }
}