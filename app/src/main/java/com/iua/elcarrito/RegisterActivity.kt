package com.iua.elcarrito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.iua.elcarrito.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

  private lateinit var binding : ActivityRegisterBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityRegisterBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)

    binding.registerButton.setOnClickListener {
      Toast.makeText(this,"Se registro correctamente", Toast.LENGTH_LONG).show()
      val intetn:Intent = Intent(this, LogActivity::class.java)
      startActivity(intetn)
    }

    binding.backButton.setOnClickListener {
      val intent: Intent = Intent(this, LogActivity::class.java)
      startActivity(intent)
    }

  }
}