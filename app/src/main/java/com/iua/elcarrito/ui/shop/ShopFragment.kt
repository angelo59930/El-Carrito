package com.iua.elcarrito.ui.shop

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.iua.elcarrito.R
import com.iua.elcarrito.data.databases.entity.ProductEntity
import com.iua.elcarrito.databinding.FragmentShopBinding
import com.iua.elcarrito.viewModel.ProductViewModel

class ShopFragment : Fragment() {

  private lateinit var binding: FragmentShopBinding
  private lateinit var productViewModel: ProductViewModel


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


    //TODO:mostrar la lista de productos en la activity


    binding.compra.setOnClickListener {
      Log.d("BOTON","PRESIONE EL BOTON COMPRAR")
      findNavController().navigate(R.id.action_nav_shop_to_orderFragment)
    }

    binding.volver.setOnClickListener {
      findNavController().navigate(R.id.action_nav_shop_to_nav_home)
    }
  }

}