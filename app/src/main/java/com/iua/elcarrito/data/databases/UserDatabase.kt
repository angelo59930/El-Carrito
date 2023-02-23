package com.iua.elcarrito.data.databases

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.iua.elcarrito.data.databases.dao.UserDAO

abstract class UserDatabase: RoomDatabase() {
    abstract fun userDAO() : UserDAO
    companion object {
        @Volatile
        private var instance: UserDatabase? = null

        fun getInstance (context : Context) : UserDatabase {
            val tmp = instance
            if (tmp != null){
                return tmp
            }
            synchronized(this){
                val newInstance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user-db"
                ).build()
                instance = newInstance
                return newInstance
            }
        }
    }
}