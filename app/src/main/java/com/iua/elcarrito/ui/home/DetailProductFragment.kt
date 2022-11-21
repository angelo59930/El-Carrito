package com.iua.elcarrito.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.iua.elcarrito.MyApplication
import com.iua.elcarrito.MyApplication.Companion.preferences
import com.iua.elcarrito.data.databases.entity.ProductEntity
import com.iua.elcarrito.databinding.FragmentDetailProductBinding
import com.iua.elcarrito.viewModel.ProductViewModel


class DetailProductFragment : Fragment() {

  private lateinit var binding: FragmentDetailProductBinding
  private lateinit var productViewModel: ProductViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = FragmentDetailProductBinding.inflate(inflater,container,false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val sName = preferences.getProductName()
    val sDesc = preferences.getProductDesc()
    val sPrice = preferences.getProductPrice()

    binding.textView17.text = sName

    binding.textView18.text = "$sDesc\nPrecio :$sPrice"

    productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)

    if (sPrice != null) {
      productViewModel.addProduct(ProductEntity(title = sName.toString(), description = sDesc.toString(), price = sPrice.toDouble()))
    }

    binding.agregar.setOnClickListener {
      Toast.makeText(context,"AGREGADO AL CARRITO",Toast.LENGTH_LONG).show()
    }

    binding.guardar.setOnClickListener {
      //TODO:agregar un producto con el estado de guardado
      Toast.makeText(context,"AGREGADO A LOS DESTACADOS",Toast.LENGTH_LONG).show()
    }

  }

}