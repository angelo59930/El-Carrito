package com.iua.elcarrito.data.databases

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.iua.elcarrito.data.databases.dao.ProductDAO
import com.iua.elcarrito.data.databases.entity.ProductEntity

//TODO:agregar un valor a la base de datos para diferenciar entre historial, guardados y carrito
@Database(entities = [ProductEntity::class], version = 1)
abstract class ProductDataBase : RoomDatabase(){

  abstract fun productDAO() : ProductDAO

  companion object {

    @Volatile
    private var instance: ProductDataBase? = null

    fun getInstance (context : Context) : ProductDataBase {
      val tmp = instance
      if (tmp != null){
        Log.d("INSTANCIA-DB","YA EXISTE")
        return tmp
      }
      synchronized(this){
        Log.d("INSTANCIA-DB","SE CREA UNA NUEVA INSTANCIA")
        val newInstance = Room.databaseBuilder(
          context.applicationContext,
          ProductDataBase::class.java,
          "product-db"
        ).build()

        Log.d("INSTANCIA-DB","INSTANCIA: $newInstance")

        instance = newInstance

        return newInstance
      }
    }

  }

}