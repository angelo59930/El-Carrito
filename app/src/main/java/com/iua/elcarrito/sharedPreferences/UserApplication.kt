package com.iua.elcarrito.sharedPreferences

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.iua.elcarrito.data.databases.ProductDataBase

class UserApplication : Application() {

  companion object{
    lateinit var preferences: Preferences
  }

  override fun onCreate() {
    super.onCreate()
    preferences = Preferences(applicationContext)
  }

}