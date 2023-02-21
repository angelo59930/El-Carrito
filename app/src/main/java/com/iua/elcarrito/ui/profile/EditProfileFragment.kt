package com.iua.elcarrito.ui.profile

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.iua.elcarrito.MyApplication.Companion.preferences
import com.iua.elcarrito.R
import com.iua.elcarrito.databinding.FragmentEditProfileBinding

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

      preferences.saveUsername(binding.editTextTextPersonName3.text.toString())
      preferences.saveMail(binding.editTextTextEmailAddress2.text.toString())
      preferences.saveLocation(binding.editTextTextPersonName4.text.toString())


      findNavController().navigate(R.id.action_editProfileFragment_to_nav_profile)

    }
  }

}