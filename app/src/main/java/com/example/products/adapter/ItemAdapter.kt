package com.example.products.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.products.R
import com.example.products.store.RemoteKeyValueStore

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
//         remoteKeyValueStore.getSync("product-desc/$productID")
//       // holder.imageView.setImageResource(item.imageResourceId)
//        holder.textView3.text = remoteKeyValueStore.getSync("product-price/$productID")
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}