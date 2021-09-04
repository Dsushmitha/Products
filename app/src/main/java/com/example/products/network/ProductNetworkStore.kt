package com.example.products.network

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface ProductNetworkStore {
    fun getProductIds(completion: (ArrayList<String>) -> Unit)
}

class ProductAPI(private val baseUrl: String) : ProductNetworkStore {

    override fun getProductIds(completion: (ArrayList<String>) -> Unit) {
        Log.d("SUSHI", "get.API call")
        val retrofit =
            Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
                .build()
        val api = retrofit.create(ProductAPIEndPoint::class.java)

        var call = api.getProductIDs()

        call.enqueue(object : Callback<ArrayList<String>> {

            @Override
            override fun onResponse(
                call: Call<ArrayList<String>>,
                response: Response<ArrayList<String>>
            ) {
                Log.d("SUSHI", "Sucess")
                completion(response.body()!!)
                print(response.body())
            }

            @Override
            override fun onFailure(call: Call<ArrayList<String>>, t: Throwable) {
               Log.d("SUSHI", t.message!!)
            }

        })

    }
}


public interface ProductAPIEndPoint {
    @GET("product-ids")
    fun getProductIDs(): Call<ArrayList<String>>
}