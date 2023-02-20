package com.iua.elcarrito.ui.shop

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.iua.elcarrito.R
import com.iua.elcarrito.data.databases.entity.ProductEntity
import com.iua.elcarrito.data.model.Product
import com.iua.elcarrito.databinding.FragmentOrderBinding
import com.iua.elcarrito.databinding.FragmentShopBinding
import com.iua.elcarrito.viewModel.ProductViewModel

class OrderFragment : Fragment() {

  private lateinit var binding: FragmentOrderBinding
  private lateinit var productViewModel: ProductViewModel


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = FragmentOrderBinding.inflate(inflater,container,false)

    var lista = emptyList<ProductEntity>()
    var total = 0.0
    var productos = ""

    productViewModel = ProductViewModel(requireActivity().application)

    productViewModel.getCartProducts.observe(viewLifecycleOwner) { products ->
      lista = products

      lista.forEach { item ->
        total += item.price
        productos += item.title + " - $${item.price}  | "
      }
      binding.textView9.text = total.toString()
      binding.textView11.text = productos
    }
    //TODO:Se puede cambiar por el correo del usuario
    binding.textView7.text = "Amanfredi986@alumnos.iua.edu.ar"
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.button.setOnClickListener {
      Toast.makeText(context,"Pedido Realizado",Toast.LENGTH_LONG).show()
      sendOrderMail()
    }
    binding.button2.setOnClickListener {
      findNavController().navigate(R.id.action_orderFragment_to_nav_home)
    }
  }

  private fun sendOrderMail() {
    val email = "amanfredi986@alumnos.iua.edu.ar"
    val subject = "Pedido de Compra"
    val message = "El pedido posee: ${binding.textView11.text} \n Total: ${binding.textView9.text}"
    val intent = Intent(Intent.ACTION_SEND)
    intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
    intent.putExtra(Intent.EXTRA_SUBJECT, subject)
    intent.putExtra(Intent.EXTRA_TEXT, message)
    intent.type = "message/rfc822"
    startActivity(Intent.createChooser(intent, "Choose an email client"))
  }

}