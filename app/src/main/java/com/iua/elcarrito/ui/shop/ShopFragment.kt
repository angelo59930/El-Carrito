package com.iua.elcarrito.ui.shop

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.iua.elcarrito.R
import com.iua.elcarrito.databinding.FragmentShopBinding

class ShopFragment : Fragment() {

  private var _binding: FragmentShopBinding? = null
  private val binding get() = _binding!!

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    _binding = FragmentShopBinding.inflate(inflater, container, false)

    binding.compra.setOnClickListener {
      Log.d("BOTON","PRESIONE EL BOTON COMPRAR")
      findNavController().navigate(R.id.action_nav_shop_to_orderFragment)
    }

    binding.volver.setOnClickListener {
      findNavController().navigate(R.id.action_nav_shop_to_nav_home)
    }

    return inflater.inflate(R.layout.fragment_shop, container, false)
  }

}