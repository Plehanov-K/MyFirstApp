package com.pliakhanau.myfirstapplication.homeWork4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.pliakhanau.myfirstapplication.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_add_coffee.*
import kotlinx.android.synthetic.main.fragment_coffe_shop.*

class CoffeShopFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_coffe_shop, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (CoffeeShop.instance.coffeeList.isNotEmpty()) {

            val coffeeList = CoffeeShop.instance.coffeeList

            coffeeList.getOrNull(0)?.let {
                Picasso.get().load(it.url).error(R.drawable.error).into(item1ImageView1)
                item1TextView1.text = it.name
                item1TextView2.text = it.price.toString().plus(" BYN")
            }
            coffeeList.getOrNull(1)?.let {
                Picasso.get().load(it.url).error(R.drawable.error).into(item2ImageView1)
                item2TextView1.text = it.name
                item2TextView2.text = it.price.toString().plus(" BYN")
            }
            coffeeList.getOrNull(2)?.let {
                Picasso.get().load(it.url).error(R.drawable.error).into(item3ImageView1)
                item3TextView1.text = it.name
                item3TextView2.text = it.price.toString().plus(" BYN")
            }
        }
    }
}