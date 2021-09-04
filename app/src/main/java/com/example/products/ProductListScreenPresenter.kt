package com.example.products

import android.view.View
import com.example.products.adapter.ItemAdapter
import com.example.products.model.Product
import com.example.products.network.ProductNetworkStore
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

class ProductListScreenPresenter(dbs: DatabaseReference, views: ProductListScreenView, networkStore: ProductNetworkStore) {

    private var db: DatabaseReference = dbs
    private var view: ProductListScreenView = views

    fun onCreate(){
       getProductIds()
    }

    private fun getProductIds() {

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

        }
        )
    }
}