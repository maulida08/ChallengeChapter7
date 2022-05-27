package com.ida.challengechapter7.data.room

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class FavoriteEntity(
    @PrimaryKey(autoGenerate = true)
    var id_favorite: Int?,
    var id_user: Int,
    var image: String,
): Parcelable