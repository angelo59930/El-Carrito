package com.iua.elcarrito.ui.saved

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.iua.elcarrito.R
import com.iua.elcarrito.adapters.ProductsAdapter
import com.iua.elcarrito.data.Product
import com.iua.elcarrito.databinding.FragmentSavedBinding

class SavedFragment : Fragment(), ProductsAdapter.ProductListOnClickListener  {

  private var _binding: FragmentSavedBinding? = null

  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentSavedBinding.inflate(inflater, container, false)

    binding.poductList.adapter = ProductsAdapter(
      listOf(
        Product("Coca","gaseosa",180),
        Product("pepsi","gaseosa",150)
      ),this)

    return binding.root
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

  override fun onItemClick(position: Int) {
    findNavController().navigate(R.id.action_nav_saved_to_detailProductFragment)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.button5.setOnClickListener {
      findNavController().navigate(R.id.action_nav_saved_to_nav_home)
    }
  }
}