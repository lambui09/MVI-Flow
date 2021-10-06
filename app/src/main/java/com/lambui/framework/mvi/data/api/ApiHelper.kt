package com.lambui.framework.mvi.data.api

import com.lambui.framework.mvi.data.model.User

interface ApiHelper {

    suspend fun getUsers(): List<User>

}