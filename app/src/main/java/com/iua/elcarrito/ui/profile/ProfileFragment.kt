package com.iua.elcarrito.ui.profile

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.iua.elcarrito.R
import com.iua.elcarrito.databinding.FragmentProfileBinding
import com.iua.elcarrito.MyApplication.Companion.preferences

class ProfileFragment : Fragment() {

  private lateinit var binding: FragmentProfileBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = FragmentProfileBinding.inflate(inflater,container,false)
    return binding.root
  }


  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.textView2.text = preferences.getUsername()
    binding.textView3.text = preferences.getMail()
    binding.textView10.text = preferences.getLocation()


    binding.editProfile.setOnClickListener {
      findNavController().navigate(R.id.action_nav_profile_to_editProfileFragment)
    }
  }

}