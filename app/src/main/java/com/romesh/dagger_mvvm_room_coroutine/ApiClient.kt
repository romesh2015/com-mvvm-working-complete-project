package com.romesh.dagger_mvvm_room_coroutine

import retrofit2.http.GET

interface ApiClient {

    @GET("/api/users?page=2")
    suspend fun getData() : DataModel
}