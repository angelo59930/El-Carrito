package com.iua.elcarrito.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.iua.elcarrito.R
import com.iua.elcarrito.adapter.ProductsAdapter
import com.iua.elcarrito.data.model.Product
import com.iua.elcarrito.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), ProductsAdapter.ProductListOnClickListener {

  private var _binding: FragmentHomeBinding? = null

  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {

    _binding = FragmentHomeBinding.inflate(inflater, container, false)

    binding.poductList.adapter = ProductsAdapter(
      listOf(
        Product("Coca","gaseosa",180),
        Product("pepsi","gaseosa",150),
        Product("Manaos","gaseosa",100),
        Product("Oreo","galletas",1200)
      ),this)


    return binding.root
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

  override fun onItemClick(position: Int) {
    findNavController().navigate(R.id.action_nav_home_to_detailProductFragment)
  }
}