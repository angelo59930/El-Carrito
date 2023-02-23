package com.iua.elcarrito.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.iua.elcarrito.data.databases.AccessDataBase
import com.iua.elcarrito.data.databases.entity.ProductEntity
import com.iua.elcarrito.data.databases.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductViewModel(application: Application) : AndroidViewModel(application) {

  val getAllProducts : LiveData<List<ProductEntity>>
  val getHistoryProducts : LiveData<List<ProductEntity>>
  val getSavedProducts : LiveData<List<ProductEntity>>
  val getCartProducts : LiveData<List<ProductEntity>>
  private val repository: ProductRepository

  init {
    val productDAO = AccessDataBase.getInstance(application).productDAO()
    repository = ProductRepository(productDAO)
    getHistoryProducts = repository.getHistory
    getSavedProducts = repository.getSaved
    getCartProducts = repository.getCart
    getAllProducts = repository.getAll
  }

  fun addProduct(productEntity: ProductEntity){
    viewModelScope.launch(Dispatchers.IO) {
      repository.addProduct(productEntity)
    }
  }

  fun updateProduct(productEntity: ProductEntity){
    viewModelScope.launch(Dispatchers.IO) {
      repository.updProduct(productEntity)
    }
  }

  fun deleteProduct(productEntity: ProductEntity){
    viewModelScope.launch(Dispatchers.IO) {
      repository.delProduct(productEntity)
    }
  }



}