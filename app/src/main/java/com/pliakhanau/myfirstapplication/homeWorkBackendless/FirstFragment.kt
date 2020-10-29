package com.pliakhanau.myfirstapplication.homeWorkBackendless

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.backendless.dto.response.ClientResponse
import com.example.backendless.entity.Client
import com.example.backendless.mappers.ClientMappers
import com.example.backendless.networking.REST_KEY
import com.example.backendless.retrofit.RetrofitFactory
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.pliakhanau.myfirstapplication.R
import com.pliakhanau.myfirstapplication.homeWorkBackendless.adapter.PersonAdapter
import com.pliakhanau.myfirstapplication.homeWorkBackendless.viewModel.ClientViewModel
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.coroutines.*


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

        val viewModel: ClientViewModel = ViewModelProvider(this).get(ClientViewModel::class.java)

        viewModel.listRates.observe(viewLifecycleOwner, Observer {
            personAdapter.updateList(viewModel.listRates.value)
        })

        viewModel.toastMessage.observe(viewLifecycleOwner, Observer {
            Toast.makeText(context, viewModel.toastMessage.value, Toast.LENGTH_SHORT).show()
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
