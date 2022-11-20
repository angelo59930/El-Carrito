package com.iua.elcarrito.data.model

import retrofit2.Call
import retrofit2.http.GET

interface ProductService {

  @GET(/* value = */ "v1/002227b3-2afe-4399-a8ab-b9853a756eb4")
  fun listProduct () : Call<ProductList>
}