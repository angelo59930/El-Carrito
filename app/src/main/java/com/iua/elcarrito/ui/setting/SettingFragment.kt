package com.iua.elcarrito.ui.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.iua.elcarrito.MyApplication
import com.iua.elcarrito.R
import com.iua.elcarrito.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {

  private var _binding: FragmentSettingBinding? = null

  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {

    _binding = FragmentSettingBinding.inflate(inflater, container, false)
    val root: View = binding.root

    return root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.button3.setOnClickListener {
      MyApplication.preferences.saveColumns(binding.editTextNumberDecimal.text.toString().toInt())
      findNavController().navigate(R.id.action_nav_setting_to_nav_home)
    }

  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}