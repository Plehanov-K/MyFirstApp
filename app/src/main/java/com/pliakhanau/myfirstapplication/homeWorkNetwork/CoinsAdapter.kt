package com.pliakhanau.myfirstapplication.homeWorkNetwork

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pliakhanau.myfirstapplication.R
import com.pliakhanau.myfirstapplication.homeWorkNetwork.entity.CoinInfo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.coin_item.view.*

private val URL_IMG = "https://s2.coinmarketcap.com/static/img/coins/64x64/"

class CoinsAdapter() : RecyclerView.Adapter<CoinsAdapter.CoinsVh>() {
    private var listRates = ArrayList<CoinInfo>()

    fun updateList(list: List<CoinInfo>?) {
        listRates = list as ArrayList<CoinInfo>
        notifyDataSetChanged()
    }

    class CoinsVh(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinsVh {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.coin_item, parent, false)
        return CoinsVh(view)
    }

    override fun getItemCount(): Int {
        return listRates.size
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: CoinsVh, position: Int) {
        holder.itemView.name_coin.text = listRates[position].name
        holder.itemView.price_coin.text = listRates[position].price.toString().plus("$")
        holder.itemView.persent_coin.text = listRates[position].percentChange1h.toString().plus("%")
        if (listRates[position].percentChange1h > 0) holder.itemView.persent_coin.setTextColor(Color.GREEN)
        else holder.itemView.persent_coin.setTextColor(Color.RED)
        Picasso.get().load("$URL_IMG${listRates[position].id}.png")
            .into(holder.itemView.image_coin)
    }
}