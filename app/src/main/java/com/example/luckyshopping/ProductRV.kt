package com.example.luckyshopping

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.luckyshopping.activity.ProductActivity
import com.example.luckyshopping.pojo.Product
import com.squareup.picasso.Picasso

class ProductRV(private val mValues: List<Product>) : RecyclerView.Adapter<ProductRV.ViewHolder?>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val capacity = "Объем видеопамяти: " + mValues[position].getVideoCardCapacity()
        holder.tvCapacity.text = capacity
        val type = "Тип видеопамяти: " + mValues[position].getVideoMemoryType()
        holder.tvType.text = type
        val price = "Цена: " + mValues[position].getPrice()
        holder.tvPrice.text = price
        holder.tvTitle.text = mValues[position].getVideoCardName()
        Picasso.with(ProductActivity.appContext)
            .load(mValues[position].getUrl())
            .into(holder.im)
    }

    override fun getItemCount(): Int {
        return mValues.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvType: TextView = itemView.findViewById<TextView>(R.id.tv_type_video_memory)
        var tvCapacity: TextView = itemView.findViewById<TextView>(R.id.tv_memory_capacity)
        var tvPrice: TextView = itemView.findViewById<TextView>(R.id.tv_price)
        var tvTitle: TextView = itemView.findViewById<TextView>(R.id.tv_title)
        var im: ImageView = itemView.findViewById(R.id.imageView)
    }

}