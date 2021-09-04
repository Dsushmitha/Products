package com.example.products.data

import com.example.products.R
import com.example.products.model.Product

class Datasource {
    fun loadProduct(): List<Product>{
        return listOf<Product>(
            Product(R.string.product_tittle_1, R.string.product_description_1, R.drawable.image1, R.string.product_price_1),
            Product(R.string.product_tittle_2, R.string.product_description_2, R.drawable.image2, R.string.product_price_2),
            Product(R.string.product_tittle_3, R.string.product_description_3, R.drawable.image3, R.string.product_price_3),
            Product(R.string.product_tittle_4, R.string.product_description_4, R.drawable.image4, R.string.product_price_4),
            Product(R.string.product_tittle_5, R.string.product_description_5, R.drawable.image5, R.string.product_price_5)
        )
    }

}