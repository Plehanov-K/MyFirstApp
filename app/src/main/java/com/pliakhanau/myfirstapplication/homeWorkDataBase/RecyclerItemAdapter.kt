package com.example.shop


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pliakhanau.myfirstapplication.R
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.item_view.view.*

class RecyclerItemAdapter() :
    RecyclerView.Adapter<RecyclerItemAdapter.ItemViewHolder>() {
    private var items = emptyList<Item>()

    fun setItems(items: List<Item>) {
        this.items = items
        notifyDataSetChanged()
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        Picasso.get().load(items[position].photoUrl).into(holder.itemView.item_image)
        holder.itemView.item_name.text = items[position].name
        holder.itemView.item_price.text = items[position].price
    }
}
