package com.iua.elcarrito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.iua.elcarrito.databinding.ActivityLogBinding
import com.iua.elcarrito.databinding.ActivityRecuperationBinding

private lateinit var binding: ActivityRecuperationBinding

class RecuperationActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityRecuperationBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)

    binding.recuperationButton.setOnClickListener {
      /* TODO:agregar intent de enviar mail*/

      Toast.makeText(applicationContext, R.string.recuperation_text_validation,Toast.LENGTH_LONG ).show()

      val intent: Intent = Intent(this, LogActivity::class.java)
      startActivity(intent)
    }

    binding.recuperationButtonBack.setOnClickListener {
      val intent: Intent = Intent(this, LogActivity::class.java)
      startActivity(intent)
    }
  }
}