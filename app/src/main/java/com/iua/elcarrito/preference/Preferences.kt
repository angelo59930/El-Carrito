package com.iua.elcarrito.preference

import android.content.Context

class Preferences(val context: Context) {
  val SHARED_NAME =  "ProdPref"
  val SHARED_PROD_NAME = "prodName"
  val SHARED_PROD_DESC = "prodDesc"
  val SHARED_PROD_PRIC = "prodPric"

  val storage = context.getSharedPreferences(SHARED_NAME, 0)

  fun saveProductName(name : String){
    storage.edit().putString(SHARED_PROD_NAME, name).apply()
  }
  fun saveProductDesc(desc : String){
    storage.edit().putString(SHARED_PROD_DESC, desc).apply()
  }
  fun saveProductPrice(price : String){
    storage.edit().putString(SHARED_PROD_PRIC, price).apply()
  }

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