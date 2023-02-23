package com.iua.elcarrito.data.databases.repository

import com.iua.elcarrito.data.databases.dao.UserDAO
import com.iua.elcarrito.data.databases.entity.UserEntity

class UserRepository(private val userDAO: UserDAO) {
  val getAll = userDAO.getAllUsers()

  suspend fun addUser(userEntity: UserEntity){
    userDAO.insertUser(userEntity)
  }

  suspend fun addUser(userEntity: List<UserEntity>){
    userDAO.insertUser(userEntity)
  }

  suspend fun delUser(userEntity: UserEntity){
    userDAO.deleteUser(userEntity)
  }

  suspend fun updUser(userEntity: UserEntity){
    userDAO.updateUser(userEntity)
  }
}
