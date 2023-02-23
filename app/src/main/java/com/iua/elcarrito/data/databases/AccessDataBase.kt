package com.iua.elcarrito.data.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.iua.elcarrito.data.databases.dao.ProductDAO
import com.iua.elcarrito.data.databases.dao.UserDAO
import com.iua.elcarrito.data.databases.entity.ProductEntity
import com.iua.elcarrito.data.databases.entity.UserEntity

@Database(entities = [ProductEntity::class, UserEntity::class], version = 1)
abstract class AccessDataBase : RoomDatabase(){

  abstract fun productDAO() : ProductDAO
  abstract fun userDAO() : UserDAO

  companion object {

    @Volatile
    private var instance: AccessDataBase? = null

    fun getInstance (context : Context) : AccessDataBase {
      val tmp = instance
      if (tmp != null){
        return tmp
      }
      synchronized(this){
        val newInstance = Room.databaseBuilder(
          context.applicationContext,
          AccessDataBase::class.java,
          "product-db"
        ).build()

        instance = newInstance

        return newInstance
      }
    }

  }

}