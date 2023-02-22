package com.iua.elcarrito

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.iua.elcarrito.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

  private lateinit var binding : ActivityRegisterBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityRegisterBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)

    binding.registerButton.setOnClickListener {
      val pass1 = binding.editTextTextPassword2.text
      val pass2 = binding.editTextTextPassword3.text
      val email = binding.editTextTextEmailAddress.text
      //TODO: Validar que la contraseña tenga mas de 6 caracteres

      if ( binding.editTextTextEmailAddress.text.isNotEmpty()){
        if (pass1.toString() == pass2.toString() && binding.editTextTextPassword2.text.isNotEmpty()){
          FirebaseAuth.getInstance().createUserWithEmailAndPassword(email.toString(), pass1.toString())
            .addOnCompleteListener(this) {
            if (it.isSuccessful) {
              Toast.makeText(this, "Se registro correctamente", Toast.LENGTH_LONG).show()
              val intetn:Intent = Intent(this, LogActivity::class.java)
              startActivity(intetn)
            }
            else {
              showAlert("Se ha producido un error al autenticar el usuario")
            }
          }
        }
        else {
          showAlert("Las contraseñas no coinciden")
        }
      }
      else {
        showAlert("Los campos no pueden estar vacios")
      }
    }

    binding.backButton.setOnClickListener {
      val intent: Intent = Intent(this, LogActivity::class.java)
      startActivity(intent)
    }

  }

  private fun showAlert(msg:String){
    val builder = AlertDialog.Builder(this)
    builder.setTitle("Error")
    builder.setMessage(msg)
    builder.setPositiveButton("Aceptar", null)
    val dialog: AlertDialog = builder.create()
    dialog.show()
  }

}