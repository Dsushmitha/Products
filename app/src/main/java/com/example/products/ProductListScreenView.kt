package com.example.products

import com.example.products.model.Product

interface ProductListScreenView {
    fun loadProductList(arrayProductIds: ArrayList<Product>)
}