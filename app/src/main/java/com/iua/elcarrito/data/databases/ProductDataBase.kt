package com.iua.elcarrito.data.databases

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.iua.elcarrito.MainActivity
import com.iua.elcarrito.data.databases.dao.ProductDAO
import com.iua.elcarrito.data.databases.entity.ProductEntity
import com.iua.elcarrito.sharedPreferences.UserApplication

@Database(entities = [ProductEntity::class], version = 1)
abstract class ProductDataBase : RoomDatabase(){

  abstract fun productDAO() : ProductDAO

  companion object {
    val roomDatabase : ProductDataBase = Room.databaseBuilder(
      /* context = */ UserApplication.myApplicationContex,
      /* klass = */ ProductDataBase::class.java,
      "Product-DataBase"
    ).build()
  }

}