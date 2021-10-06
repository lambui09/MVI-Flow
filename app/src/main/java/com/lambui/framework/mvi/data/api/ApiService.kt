package com.lambui.framework.mvi.data.api

import com.lambui.framework.mvi.data.model.User
import retrofit2.http.GET

interface ApiService {

   @GET("users")
   suspend fun getUsers(): List<User>
}