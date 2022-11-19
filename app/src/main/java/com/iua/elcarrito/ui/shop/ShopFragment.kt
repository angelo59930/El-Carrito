package com.iua.elcarrito.ui.shop

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.iua.elcarrito.MainActivity
import com.iua.elcarrito.R
import com.iua.elcarrito.data.Product
import com.iua.elcarrito.databinding.FragmentShopBinding
import com.iua.elcarrito.sharedPreferences.UserApplication
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ShopFragment : Fragment() {

  private lateinit var binding: FragmentShopBinding


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = FragmentShopBinding.inflate(inflater, container, false)

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.compra.setOnClickListener {

      Log.d("BOTON","PRESIONE EL BOTON COMPRAR")
      findNavController().navigate(R.id.action_nav_shop_to_orderFragment)
    }

    binding.volver.setOnClickListener {
      findNavController().navigate(R.id.action_nav_shop_to_nav_home)
    }
  }
}