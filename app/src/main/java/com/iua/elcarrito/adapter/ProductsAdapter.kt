package com.iua.elcarrito.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iua.elcarrito.data.model.Product
import com.iua.elcarrito.databinding.ViewProductItemBinding

class ProductsAdapter(private val products:List<Product>, private val listener: ProductListOnClickListener) : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val binding: ViewProductItemBinding = ViewProductItemBinding.inflate( LayoutInflater.from(parent.context), parent, false)
    return ViewHolder(binding, listener)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(products[position])
  }

  override fun getItemCount(): Int = products.size

  class ViewHolder(private val binding : ViewProductItemBinding, listener: ProductListOnClickListener):RecyclerView.ViewHolder(binding.root){
    fun bind(product: Product){
      binding.titleProduct.text = product.title
    }
    init {
      itemView.setOnClickListener{
        listener.onItemClick(adapterPosition)
      }
    }

  }

  interface ProductListOnClickListener{
    fun onItemClick(position: Int)
  }

}