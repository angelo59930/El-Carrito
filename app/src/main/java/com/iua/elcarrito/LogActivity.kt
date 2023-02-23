package com.iua.elcarrito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.iua.elcarrito.MyApplication.Companion.preferences
import com.iua.elcarrito.databinding.ActivityLogBinding
import com.iua.elcarrito.viewModel.UserViewModel

class LogActivity : AppCompatActivity() {

  private lateinit var binding:ActivityLogBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    setTheme(R.style.Theme_ElCarrito)
    super.onCreate(savedInstanceState)
    binding = ActivityLogBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)

    if (preferences.getIsLogged()){
      val intent = Intent(this, MainActivity::class.java)
      startActivity(intent)
    }

    binding.recuperation.setOnClickListener{
      val intent = Intent(this, RecuperationActivity::class.java)
      startActivity(intent)
    }

    binding.register.setOnClickListener {
      val intent = Intent(this, RegisterActivity::class.java)
      startActivity(intent)
    }

    binding.login.setOnClickListener {
      val pass1 = binding.editTextTextPassword.text
      val email = binding.editTextTextPersonName.text

      /*if (binding.editTextTextPersonName.text.toString().isNotEmpty()){
        UserViewModel(application).getAllUsers.observe(this ){
          for (user in it) {
            if (user.email == email.toString() && user.password == pass1.toString()) {
              preferences.setIsLogged(true)
              preferences.saveMail(email.toString())
            } else {
              return@observe
            }
          }
        }
      }*/

      // Usamos firebase para e
      if (binding.editTextTextPersonName.text.toString().isNotEmpty()){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email.toString(), pass1.toString())
          .addOnCompleteListener(this) {
            if (it.isSuccessful) {
              preferences.setIsLogged(true)
              preferences.saveMail(email.toString())
              Toast.makeText(this, "Bienvenido", Toast.LENGTH_LONG).show()
              val intent = Intent(this, MainActivity::class.java)
              startActivity(intent)
            }
            else {
              Toast.makeText(this, "login Incorrecto", Toast.LENGTH_LONG).show()

            }
          }
      }
    }
  }
}