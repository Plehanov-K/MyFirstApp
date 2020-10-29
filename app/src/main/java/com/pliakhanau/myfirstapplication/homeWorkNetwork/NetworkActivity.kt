package com.pliakhanau.myfirstapplication.homeWorkNetwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.pliakhanau.myfirstapplication.R
import com.pliakhanau.myfirstapplication.homeWorkNetwork.dto.CoinResponse
import com.pliakhanau.myfirstapplication.homeWorkNetwork.entity.CoinInfo
import com.pliakhanau.myfirstapplication.homeWorkNetwork.mapper.CoinMapper
import com.pliakhanau.myfirstapplication.homeWorkNetwork.networking.CoinApi
import com.pliakhanau.myfirstapplication.homeWorkNetwork.retrofit.RetrofitFactory
import kotlinx.android.synthetic.main.activity_network.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class NetworkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)

        val retrofit: CoinApi = RetrofitFactory().getRetrofit()
        val coinsAdapter = CoinsAdapter()

        recycler_view.adapter = coinsAdapter
        recycler_view.layoutManager = LinearLayoutManager(this)

        button_get.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {

                val response: Response<CoinResponse> = retrofit.getRates().await()

                if (response.isSuccessful) {
                    val ratesResponse: List<CoinResponse.Data>? = response.body()?.data
                    val rates: List<CoinInfo>? = ratesResponse?.map {
                        CoinMapper().map(it)
                    }
                    withContext(Dispatchers.Main) {
                        coinsAdapter.updateList(rates)
                    }
                } else {
                    Toast.makeText(this@NetworkActivity, "ERROR", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
