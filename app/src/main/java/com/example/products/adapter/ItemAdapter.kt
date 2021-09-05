package com.example.products.adapter

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.products.R
import com.example.products.store.RemoteKeyValueStore
import com.squareup.picasso.Picasso
import java.io.BufferedInputStream
import java.io.InputStream
import java.net.URL

class ItemAdapter( private val dataset: ArrayList<String>, private val remoteKeyValueStore: RemoteKeyValueStore) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view:View) : RecyclerView.ViewHolder(view){
        val textView1: TextView = view.findViewById(R.id.item_tittle)
        val textView2: TextView = view.findViewById(R.id.item_description)
        val imageView: ImageView = view.findViewById(R.id.item_image)
        val textView3: TextView = view.findViewById(R.id.product_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val productID = dataset[position]
        remoteKeyValueStore.getSyncString("product-name/$productID") { name ->
            holder.textView1.text = name
        }
        remoteKeyValueStore.getSyncString("product-desc/$productID") { desc ->
            holder.textView2.text = desc
        }
        remoteKeyValueStore.getSyncLong("product-price/$productID") { price ->
            holder.textView3.text = price.toString()
        }
        remoteKeyValueStore.getSyncString("product-image/$productID") { image ->
            Picasso.get().load(image).into(holder.imageView)

        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}