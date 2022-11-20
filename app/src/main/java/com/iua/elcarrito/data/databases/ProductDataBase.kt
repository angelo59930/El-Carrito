package com.iua.elcarrito.data.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.iua.elcarrito.data.databases.dao.ProductDAO
import com.iua.elcarrito.data.databases.entity.ProductEntity

@Database(entities = [ProductEntity::class], version = 1)
abstract class ProductDataBase : RoomDatabase(){

  abstract fun productDAO() : ProductDAO

  companion object {

    @Volatile
    private var instance: ProductDataBase? = null

    fun getInstance (context : Context) : ProductDataBase {
      val tmp = instance
      if (tmp != null)
        return tmp
      synchronized(this){
        val newInstance = Room.databaseBuilder(
          context.applicationContext,
          ProductDataBase::class.java,
          "product-db"
        ).build()

        instance = newInstance
        return newInstance
      }
    }

  }

}