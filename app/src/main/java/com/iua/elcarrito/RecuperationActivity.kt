package com.iua.elcarrito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.iua.elcarrito.databinding.ActivityRecuperationBinding

class RecuperationActivity : AppCompatActivity() {
  private lateinit var binding: ActivityRecuperationBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityRecuperationBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)

    binding.recuperationButton.setOnClickListener {
      /*
      * La logica de recuperacion de contrseña depende de un backend
      * que no se encuentra implementado en este proyecto
      * por lo que se muestra un mensaje de que se esta recuperando.
      * Lo que deberia pasar es lo siguente:
      * 1. El usuario toca el boton de recuperacion
      * 2. Se envia la peticion al back para recuperar
      * 3. Se muestra un mensaje de que se envio un mail (El back se encarga de la busqueda del usuario y envio del mail)
      * 4. Se redirige al usuario a la pantalla de login
      * */

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