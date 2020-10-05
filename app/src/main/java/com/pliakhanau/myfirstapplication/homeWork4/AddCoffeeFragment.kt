package com.pliakhanau.myfirstapplication.homeWork4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.pliakhanau.myfirstapplication.R
import kotlinx.android.synthetic.main.fragment_add_coffee.*

class AddCoffeeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_coffee, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAdd.setOnClickListener {

            val url = editUrl.text.toString().trim()
            val name = editName.text.toString().trim()
            val price = editPrice.text.toString().trim()

            if (!url.isBlank() && !name.isBlank() && !price.isBlank()) {

                CoffeeShop.instance.coffeeList.add(Coffee(url,name,price.toDouble()))

                Toast.makeText(context, "$name added", Toast.LENGTH_SHORT).show()

                view.findNavController().popBackStack()

            } else  Toast.makeText(context, "Не все поля заполнены", Toast.LENGTH_SHORT).show()
        }
    }
}