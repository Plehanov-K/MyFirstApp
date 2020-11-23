package com.pliakhanau.myfirstapplication.homeWorkRxJava.adaper

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationrxjava.entity.Country
import com.pliakhanau.myfirstapplication.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.covid_item.view.*

class CovidAdapter () : RecyclerView.Adapter<CovidAdapter.CovidVh>() {
    private var listCountry = ArrayList<Country?>()

    fun updateList(list: List<Country?>?) {
        listCountry = list as ArrayList<Country?>
        notifyDataSetChanged()
    }
    class CovidVh(view: View) : RecyclerView.ViewHolder(view)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidVh {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.covid_item, parent, false)
        return CovidVh(view)
    }

    override fun getItemCount(): Int {
        return listCountry.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CovidVh, position: Int) {
        holder.itemView.country_covid.text = listCountry[position]?.country
        holder.itemView.total_confirmed.text = " Total confirmed ${listCountry[position]?.totalConfirmed.toString()}"
        holder.itemView.price_deaths.text =" Total deaths ${ listCountry[position]?.totalDeaths.toString()}"
        holder.itemView.total_recovered.text = " Total recovered ${listCountry[position]?.totalRecovered.toString()}"
        holder.itemView.data.text = listCountry[position]?.date.toString().substringBefore("T")
        Picasso.get().load(listCountry[position]?.flagUrl)
            .into(holder.itemView.image_flag)
    }
}