package com.pliakhanau.myfirstapplication.homeWorkDataBase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.shop.Item
import com.pliakhanau.myfirstapplication.R
import com.pliakhanau.myfirstapplication.homeWorkDataBase.dao.ItemDao
import com.pliakhanau.myfirstapplication.utils.launchIo
import kotlinx.android.synthetic.main.fragment_add_item.*

class AddItemFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonAddItem.setOnClickListener {
            val db: ItemDao? = context?.let {db.getDb(it).itemDao()}

            val name = editTextName.text.toString().trim()
            val price = editTextPrice.text.toString().trim()
            val url = editTextUrl.text.toString().trim()


            if (name.isNotBlank() && price.isNotBlank() && url.isNotBlank()) {

                launchIo {
                    db?.addItem(Item(name, price, url))
                }
                Toast.makeText(context, "$name added", Toast.LENGTH_SHORT).show()

                view.findNavController().popBackStack()

            } else Toast.makeText(context, "Не все поля заполнены", Toast.LENGTH_SHORT).show()
        }
    }
}