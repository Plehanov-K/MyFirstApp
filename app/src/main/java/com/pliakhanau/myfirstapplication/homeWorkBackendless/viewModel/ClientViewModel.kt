package com.pliakhanau.myfirstapplication.homeWorkBackendless.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.backendless.dto.request.ClientAddRequest
import com.example.backendless.dto.request.ClientEditRequest
import com.example.backendless.dto.response.ClientResponse
import com.example.backendless.entity.Client
import com.example.backendless.mappers.ClientMappers
import com.example.backendless.networking.REST_KEY
import com.example.backendless.retrofit.RetrofitFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ClientViewModel : ViewModel() {
    init {
        uploadAllClients()
    }

    var toastMessage = MutableLiveData<String>()
    var listRates = MutableLiveData<List<Client>>()
    var objectId: String? =null
//        "40C8D4CE-BC47-4F25-A571-6E8C25316445"
    fun deleteClient(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val result = RetrofitFactory.provideAPI().deleteClientAsync(REST_KEY, id).await()
            if (result.isSuccessful) {
                    toastMessage.postValue("Client deleted")
            } else {
                    toastMessage.postValue("Error deleted")
            }
        }
    }

    fun uploadAllClients() {
        CoroutineScope(Dispatchers.IO).launch {
            val result = RetrofitFactory.provideAPI().getALLClientsAsync(REST_KEY).await()
            if (result.isSuccessful) {
                withContext(Dispatchers.Main) {
                    val ratesResponse: List<ClientResponse>? = result.body()
                    val rates: List<Client>? = ratesResponse?.map {
                        ClientMappers().convert(it)
                    }
                    listRates.postValue(rates)
                }
            } else {
                    toastMessage.postValue("Error")
            }
        }
    }

    fun addClient(request: ClientAddRequest) {
        if (objectId == null) {
            CoroutineScope(Dispatchers.IO).launch {
                val result = RetrofitFactory.provideAPI().addClient(REST_KEY, request).await()
                if (result.isSuccessful) {
                        toastMessage.postValue("Client added")
                } else {
                        toastMessage.postValue("Error added")
                }
            }
        } else {
            val request = ClientEditRequest(
                request.deposit,
                request.firstName,
                request.lastName,
                objectId
            )
            CoroutineScope(Dispatchers.IO).launch {
                val result = RetrofitFactory.provideAPI().editClient(
                    REST_KEY, request
                ).await()
                if (result.isSuccessful) {
                        toastMessage.postValue("Client edited")
                } else {
                        toastMessage.postValue("Error edited")
                }
            }
        }
    }
}