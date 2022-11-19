package com.iua.elcarrito.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import com.iua.elcarrito.MainActivity
import com.iua.elcarrito.R
import com.iua.elcarrito.data.databases.entity.ProductEntity
import com.iua.elcarrito.databinding.FragmentDetailProductBinding
import com.iua.elcarrito.sharedPreferences.UserApplication
import kotlinx.coroutines.launch

class DetailProductFragment : Fragment() {

  private lateinit var binding: FragmentDetailProductBinding

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

    binding.agregar.setOnClickListener {

      // RECORDAR QUE SE NECESITA PARA GENERAR LA CORRUTINA UnU
      /*lifecycleScope.launch{
        UserApplication.myAppDatabase.productDAO().insertProduct(
          ProductEntity(
            title = "test",
            description = "test description",
            price = 132
          )
        )
      }*/

      Toast.makeText(context,"AGREGADO AL CARRITO",Toast.LENGTH_LONG).show()
    }

    binding.guardar.setOnClickListener {
      Toast.makeText(context,"AGREGADO A LOS DESTACADOS",Toast.LENGTH_LONG).show()
    }

  }

}