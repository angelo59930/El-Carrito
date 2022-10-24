package com.iua.elcarrito.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iua.elcarrito.R
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
      val intent = Intent(this, RecuperationActivity::class.java)
      startActivity(intent)
    }

    binding.register.setOnClickListener {
      val intent = Intent(this, RegisterActivity::class.java)
      startActivity(intent)
    }

    binding.login.setOnClickListener {
      //val intent = Intent(this, FirstViewActivity::class.java)
      //val intent = Intent(this, MainActivity::class.java)
      startActivity(intent)
    }
  }
}