package com.iua.elcarrito.ui.profile

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.PermissionChecker
import androidx.core.content.PermissionChecker.checkSelfPermission
import androidx.fragment.app.Fragment
import com.iua.elcarrito.databinding.FragmentEditProfileBinding
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

    binding.profileImage.setOnClickListener {
      // Verificamos si tenemos los permisos para usar la camara
      // Si no los tenemos, los pedimos
      // Si los tenemos, abrimos la camara

      if (checkSelfPermission(requireContext(), android.Manifest.permission.CAMERA) == PermissionChecker.PERMISSION_DENIED) {
        requestPermissions(arrayOf(android.Manifest.permission.CAMERA), 100)
      } else {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivity(intent)
      }

    }

  }

}