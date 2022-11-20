package com.iua.elcarrito

import android.annotation.SuppressLint
import android.app.Application
import com.iua.elcarrito.preference.Preferences

class MyApplication : Application() {

  companion object{
    @SuppressLint("StaticFieldLeak")
    lateinit var preferences: Preferences
  }

  override fun onCreate() {
    super.onCreate()
    preferences = Preferences(applicationContext)
  }

}