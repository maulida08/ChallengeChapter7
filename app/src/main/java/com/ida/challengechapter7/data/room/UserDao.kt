package com.ida.challengechapter7.data.room

import androidx.room.*

@Dao
interface UserDao {
    @Query("SELECT EXISTS(SELECT * FROM User WHERE username = :username and password = :password)")
    fun checkUser(username: String, password: String): Boolean

    @Query("SELECT * FROM user WHERE username = :username AND password = :password")
    fun loginUser(username: String, password: String): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User):Long

    @Update
    fun updatetUser(user: User):Int

    @Delete
    fun deletetUser(user: User):Int
}