package com.iua.elcarrito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iua.elcarrito.databinding.ActivityFirstViewBinding

class FirstViewActivity : AppCompatActivity(), ProductsAdapter.ProductListOnClickListener {

  private lateinit var binding:ActivityFirstViewBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityFirstViewBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)
/*
    binding.poductList.adapter = ProductsAdapter(
      listOf(
        Product("Coca","gaseosa",180),
        Product("pepsi","gaseosa",150),
         Product("Manaos","gaseosa",100),
        Product("Oreo","galletas",1200)
      ),this)*/
  }

  override fun onItemClick(position: Int) {
    val intent = Intent(this, DetailProductActivity::class.java)
    startActivity(intent)
  }
}