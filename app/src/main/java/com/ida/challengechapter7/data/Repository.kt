package com.ida.challengechapter7.data

import com.ida.challengechapter7.data.room.DatabaseHelper
import com.ida.challengechapter7.data.service.ApiHelper
import kotlinx.coroutines.flow.Flow

class Repository(private val apiHelper: ApiHelper, private val databaseHelper: DatabaseHelper, private val dataStoreManager: DataStoreManager) {
    // Retrofit
    suspend fun getPopularMovie() = apiHelper.getPopularMovie()

}