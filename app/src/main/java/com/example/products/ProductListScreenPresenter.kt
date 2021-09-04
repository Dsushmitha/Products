package com.example.products

import android.util.Log
import com.example.products.model.Product
import com.example.products.network.ProductNetworkStore
import com.google.firebase.database.DatabaseReference

class ProductListScreenPresenter(
    dbs: DatabaseReference,
    views: ProductListScreenView,
    private val networkStore: ProductNetworkStore
) {

    private var db: DatabaseReference = dbs
    private var view: ProductListScreenView = views

    fun onCreate() {
        getProductIds()
        Log.d("SUSHI", "create 2")
    }

    private fun getProductIds() {
        networkStore.getProductIds { list ->
            val productl =list.map { Product("sus", it, R.drawable.image1, "$100") }
            var productList = arrayListOf<Product>()
            productList.addAll(productl)
            view.loadProductList(productList)
            Log.d("SUSHI","network  store return data")
            print(productList)
        }
    }
}

//        db.addValueEventListener(object: ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//
//                if(snapshot.exists()){
//                    var arraylist = arrayListOf<Product>()
//                    for(userSnapshot in snapshot.children){
//
//                        val id = userSnapshot.getValue(Product::class.java)
//                        arraylist.add(id!!)
//                    }
//                    view.loadProductList(arraylist)
//                }
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                TODO("Not yet implemented")
//            }