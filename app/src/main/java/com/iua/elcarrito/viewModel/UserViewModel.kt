package com.iua.elcarrito.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.iua.elcarrito.data.databases.AccessDataBase
import com.iua.elcarrito.data.databases.entity.UserEntity
import com.iua.elcarrito.data.databases.repository.ProductRepository
import com.iua.elcarrito.data.databases.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

  val getAllUsers : LiveData<List<UserEntity>>
  private val repository: UserRepository

  init {
    val userDAO = AccessDataBase.getInstance(application).userDAO()
    repository = UserRepository(userDAO)
    getAllUsers = repository.getAll
  }

  fun addUser(userEntity: UserEntity){
    viewModelScope.launch(Dispatchers.IO) {
      repository.addUser(userEntity)
    }
  }

  fun updateUser(userEntity: UserEntity){
    viewModelScope.launch(Dispatchers.IO) {
      repository.updUser(userEntity)
    }
  }

  fun deleteUser(userEntity: UserEntity){
    viewModelScope.launch(Dispatchers.IO) {
      repository.delUser(userEntity)
    }
  }

}