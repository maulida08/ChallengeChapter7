package com.ida.challengechapter7.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavorite(favoriteEntity: FavoriteEntity)

    @Query("SELECT * FROM favoriteentity WHERE id_user= :id_user")
    suspend fun getAllFavoriteById(id_user: Int): List<FavoriteEntity>

}