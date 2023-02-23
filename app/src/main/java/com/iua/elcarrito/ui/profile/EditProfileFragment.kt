package com.iua.elcarrito.ui.profile

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.PermissionChecker
import androidx.core.content.PermissionChecker.checkSelfPermission
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.iua.elcarrito.MyApplication
import com.iua.elcarrito.R
import com.iua.elcarrito.databinding.FragmentEditProfileBinding
import com.iua.elcarrito.preference.Preferences
import java.util.jar.Manifest

class EditProfileFragment : Fragment() {

  private lateinit var binding: FragmentEditProfileBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentEditProfileBinding.inflate(inflater,container,false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.completeEdit.setOnClickListener {
      val direccion = binding.direccion.text.toString()

      if(direccion.isNotEmpty())
        MyApplication.preferences.saveDireccion(direccion)

      findNavController().navigate(R.id.action_editProfileFragment_to_nav_profile)
    }

    binding.editContraseA.setOnClickListener {
      FirebaseAuth.getInstance().sendPasswordResetEmail(MyApplication.preferences.getMail().toString()).addOnCompleteListener(this.requireActivity()) {
        if (it.isSuccessful) {
          Toast.makeText(this.requireContext(), "Se ha enviado un correo para cambiar la contraseña", Toast.LENGTH_LONG).show()
        }
        else
          Toast.makeText(this.requireContext(), "No se ha podido enviar el correo", Toast.LENGTH_LONG).show()
      }
    }

    binding.profileImage.setOnClickListener {
      if (checkSelfPermission(requireContext(), android.Manifest.permission.CAMERA) == PermissionChecker.PERMISSION_DENIED) {
        requestPermissions(arrayOf(android.Manifest.permission.CAMERA), 100)
      } else {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, 100)
      }
    }
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (requestCode == 100) {
      val image = data?.extras?.get("data") as Bitmap
      binding.profilePicture.setImageBitmap(image)

      //almacenamos la imagen en una carpeta de la aplicacion
      val path = MediaStore.Images.Media.insertImage(context?.contentResolver, image, "Title", null)

      //guardamos la ruta de la imagen en las preferencias
      MyApplication.preferences.saveImage(path)

    }
  }



}