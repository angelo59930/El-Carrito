package com.iua.elcarrito.data.databases.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Products_table")
data class ProductEntity(
  @PrimaryKey(autoGenerate = true)
  var id: Long? = null,
  @ColumnInfo(name="title") val title: String,
  @ColumnInfo(name="description") val description: String,
  @ColumnInfo(name="price") val price: Double,
  // 0 = historial, 1 = guardados, 2 = carrito
  @ColumnInfo(name="state") val state: Int = 0
)