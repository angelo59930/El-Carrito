package com.iua.elcarrito.data.databases.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.iua.elcarrito.data.databases.entity.ProductEntity

@Dao
interface ProductDAO {

  @Query("SELECT * FROM products_table")
  suspend fun getAllProducts(): List<ProductEntity>

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  suspend fun insertProduct(productEntity: ProductEntity)

  @Delete
  suspend fun deleteProduct(productEntity : ProductEntity)

}