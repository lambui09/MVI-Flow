package com.lambui.framework.mvi.data.repository

import com.lambui.framework.mvi.data.api.ApiHelper


class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getUsers()

}