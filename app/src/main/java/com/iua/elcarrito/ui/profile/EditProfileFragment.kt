package com.iua.elcarrito.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.iua.elcarrito.R
import com.iua.elcarrito.databinding.FragmentEditProfileBinding

class EditProfileFragment : Fragment() {

  private lateinit var binding: FragmentEditProfileBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

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
      findNavController().navigate(R.id.action_editProfileFragment_to_nav_profile)
    }
  }

}