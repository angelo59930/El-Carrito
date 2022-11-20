package com.iua.elcarrito.preference

import android.content.Context

class Preferences(val context: Context) {
  val SHARED_NAME =  "Mydb"
  val SHARED_USER_NAME = "username"

  val storage = context.getSharedPreferences(SHARED_NAME, 0)

  fun saveUsername(username : String){
    storage.edit().putString(SHARED_USER_NAME, username).apply()
  }

  fun getUsername(): String? {
    return storage.getString(SHARED_USER_NAME, "")
  }

}