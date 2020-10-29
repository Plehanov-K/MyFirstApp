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

var toastMessage = MutableLiveData<String>()
var listRates = MutableLiveData<List<Client>>()
var objectId: String? = null

class ClientViewModel : ViewModel() {
    init {
        uploadAllClients()
    }

    fun deleteClient(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val result = RetrofitFactory.provideAPI().deleteClientAsync(REST_KEY, id).await()
            if (result.isSuccessful) {
                withContext(Dispatchers.Main) {
                    toastMessage.value = ("Client deleted")
                }
                uploadAllClients()
            } else {
                withContext(Dispatchers.Main) {
                    toastMessage.value = ("Error deleted")
                }
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
                    listRates.value = (rates)
                }
            } else withContext(Dispatchers.Main) {
                toastMessage.value = ("Error")
            }
        }
    }


    fun addClient(request: ClientAddRequest) {
        if (objectId.isNullOrEmpty()) {
            CoroutineScope(Dispatchers.IO).launch {
                val result = RetrofitFactory.provideAPI().addClient(REST_KEY, request).await()
                if (result.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        withContext(Dispatchers.Main) {
                            toastMessage.value = ("Client added")
                        }
                    }
                    uploadAllClients()
                } else {
                    withContext(Dispatchers.Main) {
                        toastMessage.value = ("Error added")
                    }
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
                    withContext(Dispatchers.Main) {
                        toastMessage.value = "Client edited"
                        objectId = null
                    }
                    uploadAllClients()
                } else {
                    withContext(Dispatchers.Main) {
                        toastMessage.value = ("Error edited")
                    }
                }
            }
        }
    }
}