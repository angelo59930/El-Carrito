package com.iua.elcarrito.data.databases.repository

import androidx.lifecycle.LiveData
import com.iua.elcarrito.data.databases.dao.ProductDAO
import com.iua.elcarrito.data.databases.entity.ProductEntity

class ProductRepository(private val productDAO: ProductDAO) {

  val getAll : LiveData<List<ProductEntity>> = productDAO.getAllProducts()

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