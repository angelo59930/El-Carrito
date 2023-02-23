package com.iua.elcarrito.data.model

import retrofit2.Call
import retrofit2.http.GET

interface ProductService {

  @GET(/* value = */ "v1/b28501e5-a662-4ebe-8bc8-4f4e4697f309")
  fun listProduct () : Call<ProductList>
}