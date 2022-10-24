package com.iua.elcarrito.ui.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.iua.elcarrito.R
import com.iua.elcarrito.adapters.ProductsAdapter
import com.iua.elcarrito.dataClass.Product
import com.iua.elcarrito.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment(), ProductsAdapter.ProductListOnClickListener  {

  lateinit var binding:FragmentHistoryBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentHistoryBinding.inflate(inflater)

    binding.poductList.adapter = ProductsAdapter(
      listOf(
        Product("Coca","gaseosa",180),
        Product("pepsi","gaseosa",150)
      ),this)

    return binding.root
  }

  override fun onItemClick(position: Int) {
    findNavController().navigate(R.id.action_nav_history_to_detailProductFragment)
  }

}