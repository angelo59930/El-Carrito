package com.iua.elcarrito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.iua.elcarrito.databinding.ActivityRecuperationBinding

class RecuperationActivity : AppCompatActivity() {
  private lateinit var binding: ActivityRecuperationBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityRecuperationBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)

    binding.recuperationButton.setOnClickListener {

      if(binding.emailtext.text.toString().isEmpty()){
        Toast.makeText(this, "El campo no puede estar vacio", Toast.LENGTH_LONG).show()
        return@setOnClickListener
      }

      FirebaseAuth.getInstance().sendPasswordResetEmail(binding.emailtext.text.toString())
        .addOnCompleteListener(this) {
          if (it.isSuccessful) {
            Toast.makeText(this, "Se envio un mail para recuperar la contraseña", Toast.LENGTH_LONG).show()
            val intent = Intent(this, LogActivity::class.java)
            startActivity(intent)
          }
          else {
            Toast.makeText(this, "No se encontro el usuario", Toast.LENGTH_LONG).show()
          }
        }
    }

    binding.recuperationButtonBack.setOnClickListener {
      val intent: Intent = Intent(this, LogActivity::class.java)
      startActivity(intent)
    }
  }
}