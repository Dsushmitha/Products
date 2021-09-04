package com.example.products.model

import androidx.annotation.DrawableRes


data class Product( var name: String ?=null,
                    var desc: String ?=null,
                   @DrawableRes val imageResourceId : Int,
                    val price:String ?=null){

}
