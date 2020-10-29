package com.example.shop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.pliakhanau.myfirstapplication.R
import com.pliakhanau.myfirstapplication.homeWorkDataBase.dao.ItemDao
import com.pliakhanau.myfirstapplication.homeWorkDataBase.db
import com.pliakhanau.myfirstapplication.utils.launchForResult
import com.pliakhanau.myfirstapplication.utils.launchIo
import com.pliakhanau.myfirstapplication.utils.launchUi
import kotlinx.android.synthetic.main.fragment_catalog.*


class CatalogFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_catalog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = RecyclerItemAdapter()
        val db: ItemDao? = context?.let { db.getDb(it).itemDao() }

        launchIo {
            launchForResult {
                val resultSetItem: List<Item>? = db?.getAllItem()
                launchUi {
                    resultSetItem?.let {
                        adapter.setItems(resultSetItem)
                    }
                }
            }
        }

        recyclerView_catalog.adapter = adapter
        recyclerView_catalog.layoutManager = LinearLayoutManager(context)
        recyclerView_catalog.hasFixedSize()

        floatingActionButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_catalogFragment_to_addItemFragment)
        }
    }
}
