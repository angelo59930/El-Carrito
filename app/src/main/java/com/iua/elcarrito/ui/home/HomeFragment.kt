package com.iua.elcarrito.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.iua.elcarrito.MyApplication.Companion.preferences
import com.iua.elcarrito.R
import com.iua.elcarrito.adapter.ProductsAdapter
import com.iua.elcarrito.data.model.Product
import com.iua.elcarrito.data.model.ProductClient
import com.iua.elcarrito.data.model.ProductList
import com.iua.elcarrito.databinding.FragmentHomeBinding
import kotlin.concurrent.thread

class HomeFragment : Fragment(), ProductsAdapter.ProductListOnClickListener {

  private var _binding: FragmentHomeBinding? = null
  private lateinit var productArray: ArrayList<Product>

  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {

    _binding = FragmentHomeBinding.inflate(inflater, container, false)

    productArray = arrayListOf()

    thread {
      val listProducts = ProductClient.service.listProduct()
      val body = listProducts.execute().body()

      Log.d("NETWORKING", "body == null? : ${body == null}")
      if(body != null) {
        productArray = body
        Log.d("NETWORKING", "body:\n $productArray")
      }

      activity?.runOnUiThread{
        binding.poductList.adapter = ProductsAdapter(productArray,this)
      }
    }

    return binding.root
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

  //TODO: agregar al resto de recyclerViews
  override fun onItemClick(position: Int) {
    Log.d("PROD-PREF", "Producto: $productArray[position]")

    preferences.saveProductName(productArray[position].title)
    preferences.saveProductDesc(productArray[position].description)
    preferences.saveProductPrice(productArray[position].price.toString())

    findNavController().navigate(R.id.action_nav_home_to_detailProductFragment)
  }
}