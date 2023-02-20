package com.iua.elcarrito.data.databases.repository

import androidx.lifecycle.LiveData
import com.iua.elcarrito.data.databases.dao.ProductDAO
import com.iua.elcarrito.data.databases.entity.ProductEntity

class ProductRepository(private val productDAO: ProductDAO) {

  val getAll : LiveData<List<ProductEntity>> = productDAO.getAllProducts()
  val getHistory : LiveData<List<ProductEntity>> = productDAO.getHistoryProducts()
  val getSaved : LiveData<List<ProductEntity>> = productDAO.getSavedProducts()
  val getCart : LiveData<List<ProductEntity>> = productDAO.getCartProducts()

  suspend fun addProduct(productEntity: ProductEntity){
    productDAO.insertProduct(productEntity)
  }

  suspend fun addProduct(productEntity: List<ProductEntity>){
    productDAO.insertProduct(productEntity)
  }

  suspend fun delProduct(productEntity: ProductEntity){
    productDAO.deleteProduct(productEntity)
  }

  suspend fun updProduct(productEntity: ProductEntity){
    productDAO.updateProduct(productEntity)
  }

}