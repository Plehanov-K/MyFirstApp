package com.pliakhanau.myfirstapplication.homeWorkBackendless

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.backendless.dto.request.ClientAddRequest
import com.example.backendless.dto.request.ClientEditRequest
import com.example.backendless.networking.REST_KEY
import com.example.backendless.retrofit.RetrofitFactory
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.pliakhanau.myfirstapplication.R
import com.pliakhanau.myfirstapplication.homeWorkBackendless.viewModel.ClientViewModel
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel: ClientViewModel = ViewModelProvider(this).get(ClientViewModel::class.java)

        butoon_add_client.setOnClickListener {
            val first_name = input_first_name.text.toString()
            val last_name = input_last_name.text.toString()
            val deposit = input_deposit.text.toString()
            if (first_name.isNotEmpty() && last_name.isNotEmpty() && deposit.isNotEmpty() && deposit.isDigitsOnly()) {
                val request = ClientAddRequest(deposit.toDouble(), first_name, last_name)
                viewModel.addClient(request)
                findNavController().popBackStack()
            } else Toast.makeText(context, "Some fields filled incorrectly", Toast.LENGTH_SHORT).show()
        }
    }
}