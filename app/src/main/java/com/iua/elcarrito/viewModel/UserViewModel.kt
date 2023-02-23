package com.iua.elcarrito.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.iua.elcarrito.data.databases.UserDatabase
import com.iua.elcarrito.data.databases.entity.UserEntity
import com.iua.elcarrito.data.databases.repository.UserRepository
import com.iua.elcarrito.data.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application)  {

  val getAllUsers : LiveData<List<UserEntity>>
  private val repository: UserRepository

  init {
    val userDAO = UserDatabase.getInstance(application).userDAO()
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

}