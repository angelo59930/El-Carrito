package com.iua.elcarrito.ui.saved

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.iua.elcarrito.R
import com.iua.elcarrito.adapter.ProductsAdapter
import com.iua.elcarrito.data.databases.entity.ProductEntity
import com.iua.elcarrito.data.model.Product
import com.iua.elcarrito.databinding.FragmentSavedBinding
import com.iua.elcarrito.viewModel.ProductViewModel

class SavedFragment : Fragment(), ProductsAdapter.ProductListOnClickListener  {

  private var _binding: FragmentSavedBinding? = null
  private lateinit var productViewModel: ProductViewModel
  private var saved = emptyList<Product>()
  var lista = emptyList<ProductEntity>()
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentSavedBinding.inflate(inflater, container, false)

    productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
    productViewModel.getSavedProducts.observe(viewLifecycleOwner) { products ->
      lista = products
      Log.d("SAVED", "CARRITO : $products")
      lista.forEach { item ->
        val productTmp =
          Product(title = item.title, description = item.description, price = item.price)
        val tmp = saved + productTmp
        Log.d("SAVED", "item actual: $productTmp")
        Log.d("SAVED", "item actual: $productTmp")
        Log.d("SAVED", "lista actual: $tmp")
        saved = tmp
      }
      binding.poductList.adapter = ProductsAdapter(saved, this)
    }
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