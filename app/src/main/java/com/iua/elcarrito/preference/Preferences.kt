package com.iua.elcarrito.preference

import android.content.Context

class Preferences(val context: Context) {
  // Preference del producto
  val SHARED_NAME =  "ProdPref"
  val SHARED_PROD_NAME = "prodName"
  val SHARED_PROD_DESC = "prodDesc"
  val SHARED_PROD_PRIC = "prodPric"

  //Prefence del usuario
  val SHARED_USER = "username"

  val storage = context.getSharedPreferences(SHARED_NAME, 0)

  // Save del producto
  fun saveProductName(name : String){
    storage.edit().putString(SHARED_PROD_NAME, name).apply()
  }
  fun saveProductDesc(desc : String){
    storage.edit().putString(SHARED_PROD_DESC, desc).apply()
  }
  fun saveProductPrice(price : String){
    storage.edit().putString(SHARED_PROD_PRIC, price).apply()
  }

  // Save del producto
  fun saveUsername(username : String){
    storage.edit().putString(SHARED_USER,username ).apply()
  }

  // Get del producto
  fun getUsername(): String?{
   return storage.getString(SHARED_USER,"")
  }

  // Get del producto
  fun getProductName(): String? {
    return storage.getString(SHARED_PROD_NAME, "")
  }

  fun getProductDesc(): String? {
    return storage.getString(SHARED_PROD_DESC, "")
  }

  fun getProductPrice(): String? {
    return storage.getString(SHARED_PROD_PRIC, "")
  }

}