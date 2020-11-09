package com.pliakhanau.myfirstapplication.homeWorkBackendless

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.pliakhanau.myfirstapplication.R
import com.pliakhanau.myfirstapplication.homeWorkBackendless.adapter.PersonAdapter
import com.pliakhanau.myfirstapplication.homeWorkBackendless.viewModel.listRates
import com.pliakhanau.myfirstapplication.homeWorkBackendless.viewModel.toastMessage
import kotlinx.android.synthetic.main.fragment_first.*


class FirstFragment : Fragment(), PersonAdapter.ButtonClick {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val personAdapter = PersonAdapter(this)
        recycleView_clients.adapter = personAdapter
        recycleView_clients.layoutManager = LinearLayoutManager(context)

        listRates.observe(viewLifecycleOwner, Observer {
            personAdapter.updateList(listRates.value)
        })

        toastMessage.observe(viewLifecycleOwner, Observer {
            toastMessage.value?.let { Toast.makeText(context, toastMessage.value,
                Toast.LENGTH_SHORT).show()
            }
            toastMessage.postValue(null)
        })

        fab.setOnClickListener {
            val nav = findNavController()
            nav.navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onBtnEdit() {
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
    }
}
