package com.iua.elcarrito

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.iua.elcarrito.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private lateinit var binding:ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    setTheme(R.style.Theme_ElCarrito)
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)

  }
}