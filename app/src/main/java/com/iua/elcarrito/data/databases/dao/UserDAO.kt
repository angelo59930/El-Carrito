package com.iua.elcarrito.data.databases.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.iua.elcarrito.data.databases.entity.ProductEntity
import com.iua.elcarrito.data.databases.entity.UserEntity

@Dao
interface UserDAO {

  @Query("SELECT * FROM users_table")
  fun getAllUsers(): LiveData<List<UserEntity>>

  @Query("SELECT * FROM users_table WHERE email = :email")
  fun getUser(email: String): LiveData<UserEntity>

  @Query("SELECT * FROM users_table WHERE email = :email AND password = :password")
  fun getUser(email: String, password: String): LiveData<UserEntity>

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  suspend fun insertUser(userEntity: UserEntity)

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  suspend fun insertUser(userEntity: List<UserEntity>)

  @Update(onConflict = OnConflictStrategy.IGNORE)
  suspend fun updateUser(userEntity: UserEntity)

  @Delete
  suspend fun deleteUser(userEntity : UserEntity)

}