package com.iua.elcarrito.ui.history

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.iua.elcarrito.R
import com.iua.elcarrito.adapter.ProductsAdapter
import com.iua.elcarrito.data.databases.entity.ProductEntity
import com.iua.elcarrito.data.model.Product
import com.iua.elcarrito.data.model.ProductClient
import com.iua.elcarrito.databinding.FragmentHistoryBinding
import com.iua.elcarrito.viewModel.ProductViewModel
import kotlin.concurrent.thread

class HistoryFragment : Fragment(), ProductsAdapter.ProductListOnClickListener  {

  lateinit var binding:FragmentHistoryBinding
  private lateinit var productViewModel: ProductViewModel
  private var history = emptyList<Product>()
  //private lateinit var productList : List<ProductEntity>
  var lista = emptyList<ProductEntity>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentHistoryBinding.inflate(inflater)

    history = listOf()

    productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)

    productViewModel.getAllProducts.observe(viewLifecycleOwner) { products ->
      lista = products
      Log.d("HISTORY", "HISTORIAL : $products")
    }
    //FIXME:CORREGIR PORQUE NO SE PASA EL HISTORIAL
    lista.forEach { item ->
      run {
        val productTmp = Product(title = item.title, description = item.description, price = item.price)
        val tmp = history + productTmp
        Log.d("HISTORY","item actual: $productTmp")
        Log.d("HISTORY","item actual: $productTmp")
        Log.d("HISTORY","lista actual: $tmp")
        history = tmp
      }
    }

    binding.poductList.adapter = ProductsAdapter(history,this)

    return binding.root
  }

  override fun onItemClick(position: Int) {
    findNavController().navigate(R.id.action_nav_history_to_detailProductFragment)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.button5.setOnClickListener {
      findNavController().navigate(R.id.action_nav_history_to_nav_home)
    }
  }

}