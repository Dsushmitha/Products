package com.example.products

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.products.adapter.ItemAdapter
import com.example.products.model.Product
import com.google.firebase.database.*

class MainActivity : AppCompatActivity(), ProductListScreenView {

    private lateinit var recyclerView: RecyclerView
    private lateinit var presenter: ProductListScreenPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        val db = FirebaseDatabase.getInstance().getReference("ids")
        presenter = ProductListScreenPresenter(db, this)
        presenter.onCreate()
    }

    override fun loadProductList(arrayProductIds: ArrayList<Product>) {
        recyclerView.adapter = ItemAdapter(arrayProductIds)
    }
}
