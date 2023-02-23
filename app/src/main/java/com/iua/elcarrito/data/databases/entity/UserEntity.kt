package com.iua.elcarrito.data.databases.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_table")
data class UserEntity(
  @PrimaryKey(autoGenerate = true)
  var id: Long? = null,
  @ColumnInfo(name="email") val email: String,
  @ColumnInfo(name="password") val password: String,
  @ColumnInfo(name="location") val location: String
)