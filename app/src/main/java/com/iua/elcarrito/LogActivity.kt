package com.iua.elcarrito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iua.elcarrito.databinding.ActivityLogBinding

class LogActivity : AppCompatActivity() {

  private lateinit var binding:ActivityLogBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    setTheme(R.style.Theme_ElCarrito)
    super.onCreate(savedInstanceState)
    binding = ActivityLogBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)

    binding.recuperation.setOnClickListener{
      val intent:Intent = Intent(this, RecuperationActivity::class.java)
      startActivity(intent)
    }

  }
}