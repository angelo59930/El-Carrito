package com.iua.elcarrito.data.databases.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.iua.elcarrito.data.databases.entity.UserEntity

interface UserDAO {

      @Query("SELECT * FROM user_table")
      fun getAllUsers(): LiveData<List<UserEntity>>

      @Query("SELECT * FROM user_table WHERE email = :email")
      fun getUser(email: String): LiveData<UserEntity>

      @Insert(onConflict = OnConflictStrategy.IGNORE)
      suspend fun insertUser(userEntity: UserEntity)

      @Insert(onConflict = OnConflictStrategy.IGNORE)
      suspend fun insertUser(userEntity: List<UserEntity>)

      @Update(onConflict = OnConflictStrategy.IGNORE)
      suspend fun updateUser(userEntity: UserEntity)

      @Delete
      suspend fun deleteUser(userEntity : UserEntity)
}