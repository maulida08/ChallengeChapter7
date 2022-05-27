package com.ida.challengechapter7.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.ida.challengechapter7.data.room.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStoreManager(private val context: Context) {
    companion object {
        private const val DATASTORE_NAME = "user_preferences"
        private val ID_USER_KEY = intPreferencesKey("id_user_key")
        private val NAMA_KEY = stringPreferencesKey("nama_key")
        private val EMAIL_KEY = stringPreferencesKey("email_key")
        private val USERNAME_KEY = stringPreferencesKey("username_key")
        private val PASSWORD_KEY = stringPreferencesKey("password_key")
        private val IMAGE_KEY = stringPreferencesKey("image_key")
        const val DEF_ID = -1
        const val DEF_NAMA = "default_nama"
        const val DEF_EMAIL = "default_email@gmail.com"
        const val DEF_USERNAME = "default_username"
        const val DEF_PASSWORD = "default_password"
        const val DEF_IMAGE = "no_image"
        val Context.userDataStore by preferencesDataStore(DATASTORE_NAME)
    }
}