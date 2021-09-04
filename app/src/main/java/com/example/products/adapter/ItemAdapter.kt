package com.example.products.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.products.R
import com.example.products.model.Product

class ItemAdapter( private val dataset: ArrayList<Product>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
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
        val item = dataset[position]
        holder.textView1.text = item.name
        holder.textView2.text = item.desc
        holder.imageView.setImageResource(item.imageResourceId)
        holder.textView3.text = item.price
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}