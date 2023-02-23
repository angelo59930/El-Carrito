package com.iua.elcarrito.preference

import android.content.Context
import android.graphics.Bitmap
import android.media.Image

class Preferences(val context: Context) {
  // Preference del producto
  val SHARED_NAME =  "ProdPref"
  val SHARED_PROD_NAME = "prodName"
  val SHARED_PROD_DESC = "prodDesc"
  val SHARED_PROD_PRIC = "prodPric"

  //Prefence del usuario

  val SHARED_MAIL = "mail"
  val SHARED_IMAGE = "path"
  val SHARED_DIRECTION = "direccion"

  // settings
  val SHARED_COMLUMNS = "columns"

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

  fun saveMail(mail : String){
    storage.edit().putString(SHARED_MAIL,mail ).apply()
  }

  fun getMail(): String?{
    return storage.getString(SHARED_MAIL,"")
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

  fun setIsLogged(login: Boolean) {
    storage.edit().putBoolean("isLogged", login).apply()
  }

  fun getIsLogged(): Boolean {
    return storage.getBoolean("isLogged",false)
  }

  fun saveDireccion(direccion: String) {
    storage.edit().putString(SHARED_DIRECTION,direccion).apply()
  }

  fun getDireccion(): String? {
    return storage.getString(SHARED_DIRECTION,"")
  }

  fun saveImage(path: String?) {
    storage.edit().putString(SHARED_IMAGE,path).apply()
  }

  fun getImage():String ? {
    return storage.getString(SHARED_IMAGE,"")
  }

  fun saveColumns(toInt: Int) {
    storage.edit().putInt(SHARED_COMLUMNS,toInt).apply()
  }

  fun geaColumns(): Int {
    return storage.getInt(SHARED_COMLUMNS,2)
  }

  fun saveImageProduct(image: String) {
    return storage.edit().putString("imageProduct",image).apply()
  }

  fun getImageProduct():String?{
    return storage.getString("imageProduct","")
  }

}