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
  val SHARED_MAIL = "mail"
  val SHARED_LOCATION = "location"

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

  // Save del usuario
  fun saveUsername(username : String){
    storage.edit().putString(SHARED_USER,username ).apply()
  }

  fun saveMail(mail : String){
    storage.edit().putString(SHARED_MAIL,mail ).apply()
  }

  fun saveLocation(location: String){
    storage.edit().putString(SHARED_LOCATION,location).apply()
  }

  // Get del usuario
  fun getUsername(): String?{
   return storage.getString(SHARED_USER,"")
  }

  fun getMail(): String?{
    return storage.getString(SHARED_MAIL,"")
  }

  fun getLocation():String?{
    return storage.getString(SHARED_LOCATION,"")
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