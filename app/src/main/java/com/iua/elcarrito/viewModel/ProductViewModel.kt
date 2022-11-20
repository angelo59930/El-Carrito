package com.iua.elcarrito.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.iua.elcarrito.data.databases.ProductDataBase
import com.iua.elcarrito.data.databases.entity.ProductEntity
import com.iua.elcarrito.data.databases.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductViewModel(application: Application) : AndroidViewModel(application) {
  val getAllProducts : LiveData<List<ProductEntity>>
  private val repository: ProductRepository

  init {
    val productDAO = ProductDataBase.getInstance(application).productDAO()
    repository = ProductRepository(productDAO)
    getAllProducts = repository.getAll
  }

  fun addProduct(productEntity: ProductEntity){
    viewModelScope.launch(Dispatchers.IO) {
      repository.addProduct(productEntity)
    }
  }

  fun addProduct(productEntity: List<ProductEntity>){
    viewModelScope.launch(Dispatchers.IO) {
      repository.addProduct(productEntity)
    }
  }

  fun delProduct(productEntity: ProductEntity){
    viewModelScope.launch(Dispatchers.IO) {
      repository.delProduct(productEntity)
    }
  }

  fun updProduct(productEntity: ProductEntity) {
    viewModelScope.launch(Dispatchers.IO) {
      repository.updProduct(productEntity)
    }
  }

}