package com.pliakhanau.myfirstapplication.homeWorkBackendless.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.backendless.entity.Client
import com.pliakhanau.myfirstapplication.R
import com.pliakhanau.myfirstapplication.homeWorkBackendless.viewModel.ClientViewModel
import com.pliakhanau.myfirstapplication.homeWorkBackendless.viewModel.objectId
import kotlinx.android.synthetic.main.item.view.*

class PersonAdapter(private val fragment :Fragment) : RecyclerView.Adapter<PersonAdapter.PersonVH>() {

    interface ButtonClick {
        fun onBtnEdit()
    }

    private var listRates = ArrayList<Client>()

    private val viewModel: ClientViewModel = ViewModelProvider(fragment).get(ClientViewModel::class.java)

    fun updateList(list: List<Client>?) {
        listRates = list as ArrayList<Client>
        notifyDataSetChanged()
    }

    class PersonVH(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return PersonVH(view)
    }

    override fun onBindViewHolder(holder: PersonVH, position: Int) {
        holder.itemView.item_first_name.text = listRates[position].firstName
        holder.itemView.item_last_name.text = listRates[position].lastName
        holder.itemView.item_deposit.text = listRates[position].deposit.toString().plus("$")
        val objectID=listRates[position].objectId

        holder.itemView.item_delete_button.setOnClickListener {
            viewModel.deleteClient(objectID)
        }

        holder.itemView.item_edit_button.setOnClickListener {
            objectId = objectID
            val nav = fragment as ButtonClick
            nav.onBtnEdit()
        }
    }

    override fun getItemCount(): Int {
        return listRates.size
    }
}