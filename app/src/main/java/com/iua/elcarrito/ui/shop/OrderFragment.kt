package com.iua.elcarrito.ui.shop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.iua.elcarrito.R
import com.iua.elcarrito.databinding.FragmentOrderBinding

class OrderFragment : Fragment() {

  private lateinit var binding: FragmentOrderBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = FragmentOrderBinding.inflate(inflater,container,false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.button.setOnClickListener {
      Toast.makeText(context,"Pedido Realizado",Toast.LENGTH_LONG).show()
      findNavController().navigate(R.id.action_orderFragment_to_nav_home)
    }
    binding.button2.setOnClickListener {
      findNavController().navigate(R.id.action_orderFragment_to_nav_home)
    }
  }

}