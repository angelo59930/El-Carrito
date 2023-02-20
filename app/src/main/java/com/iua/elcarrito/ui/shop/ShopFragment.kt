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
import com.iua.elcarrito.adapter.ProductsAdapter
import com.iua.elcarrito.data.databases.entity.ProductEntity
import com.iua.elcarrito.data.model.Product
import com.iua.elcarrito.databinding.FragmentShopBinding
import com.iua.elcarrito.viewModel.ProductViewModel

class ShopFragment : Fragment(), ProductsAdapter.ProductListOnClickListener {

  private lateinit var binding: FragmentShopBinding
  private lateinit var productViewModel: ProductViewModel
  private var cart = emptyList<Product>()
  var lista = emptyList<ProductEntity>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
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

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = FragmentShopBinding.inflate(inflater)
    productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
    productViewModel.getCartProducts.observe(viewLifecycleOwner) { products ->
      lista = products
      Log.d("CART", "CARRITO : $products")
      lista.forEach { item ->
        val productTmp =
          Product(title = item.title, description = item.description, price = item.price)
        val tmp = cart + productTmp
        Log.d("CART", "item actual: $productTmp")
        Log.d("CART", "item actual: $productTmp")
        Log.d("CART", "lista actual: $tmp")
        cart = tmp
      }
      binding.poductList.adapter = ProductsAdapter(cart, this)
    }
    return binding.root
  }

  override fun onItemClick(position: Int) {
    findNavController().navigate(R.id.action_nav_shop_to_detailProductFragment)
  }

}