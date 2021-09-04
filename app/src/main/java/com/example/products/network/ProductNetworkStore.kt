package com.example.products.network

import com.example.products.R
import com.example.products.model.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface ProductNetworkStore {
    fun getProductIds(completion: (ArrayList<String>) -> Void)
}

class ProductAPI(private val baseUrl: String) : ProductNetworkStore {

    override fun getProductIds(completion: (ArrayList<String>) -> Void) {

        val retrofit = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
        val api = retrofit.create(ProductAPIEndPoint::class.java)

        api.getProductIDs().enqueue(object: Callback<ArrayList<String>> {

            @Override
            public fun onResponse(call: Call<ArrayList<String>>, response: Response<ArrayList<String>>) {

                completion(response.body()!!)

            }

            @Override
            public fun onFailure(call: Call<Array<String>>?, t: Throwable?) {

            }

        })

    }
}


public interface ProductAPIEndPoint {
    @GET("product-ids")
    fun getProductIDs() : Call<ArrayList<String>>
}