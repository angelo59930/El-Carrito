package com.iua.elcarrito.data.databases.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.iua.elcarrito.data.databases.entity.ProductEntity

@Dao
interface ProductDAO {

  @Query("SELECT * FROM products_table")
  fun getAllProducts(): LiveData<List<ProductEntity>>

  @Query("SELECT * FROM products_table WHERE state = 0")
  fun getHistoryProducts(): LiveData<List<ProductEntity>>

  @Query("SELECT * FROM products_table WHERE state = 1")
  fun getSavedProducts(): LiveData<List<ProductEntity>>

  @Query("SELECT * FROM products_table WHERE state = 2")
  fun getCartProducts(): LiveData<List<ProductEntity>>

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  suspend fun insertProduct(productEntity: ProductEntity)

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  suspend fun insertProduct(productEntity: List<ProductEntity>)

  @Update(onConflict = OnConflictStrategy.IGNORE)
  suspend fun updateProduct(productEntity: ProductEntity)

  @Delete
  suspend fun deleteProduct(productEntity : ProductEntity)

}