package com.ida.challengechapter7.data.room

class DatabaseHelper(private val favoriteDao: FavoriteDao, private val userDao: UserDao) {
    // Favorite
    suspend fun addFavorite(favoriteEntity: FavoriteEntity) = favoriteDao.addFavorite(favoriteEntity)

    // User
}