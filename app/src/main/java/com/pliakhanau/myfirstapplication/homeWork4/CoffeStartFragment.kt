package com.pliakhanau.myfirstapplication.homeWork4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.pliakhanau.myfirstapplication.R
import kotlinx.android.synthetic.main.fragment_coffe_start.*

class CoffeStartFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_coffe_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAddCoffee.setOnClickListener {
            view.findNavController().navigate(R.id.action_coffeStartFragment_to_addCoffeeFragment)
        }

        btnCollections.setOnClickListener {
            view.findNavController().navigate(R.id.action_coffeStartFragment_to_coffeShopFragment)
        }
    }
}