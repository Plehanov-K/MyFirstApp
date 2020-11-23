package com.pliakhanau.myfirstapplication.homeWorkRxJava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplicationrxjava.mappers.SummaryMapper
import com.example.myapplicationrxjava.retrofit.RetrofitFactory
import com.pliakhanau.myfirstapplication.R
import com.pliakhanau.myfirstapplication.homeWorkRxJava.adaper.CovidAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_covid.*

class CovidActivity : AppCompatActivity() {

    private lateinit var compositeDisposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_covid)

        val covidAdapter = CovidAdapter()
        recycler_view_covid.adapter = covidAdapter
        recycler_view_covid.layoutManager = LinearLayoutManager(this)

        compositeDisposable = CompositeDisposable()

        val api = RetrofitFactory().provideApi()

        val summaryDisposable = api.getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { summaryResponse ->
                summaryResponse.countries?.map {
                    it?.flagUrl =
                        "https://www.countryflags.io/${it?.countryCode}/shiny/64.png"
                    it
                }
            }
            .subscribe({ listOfResponsePlusUrl ->
                val list = listOfResponsePlusUrl?.map { response ->
                    response?.let { SummaryMapper.map(it) }
                }
                covidAdapter.updateList(list)
            }, {
                Log.e("AAA", it.localizedMessage)
            })

        compositeDisposable.add(summaryDisposable)

    }

    override fun onStop() {
        compositeDisposable.dispose()
        super.onStop()

    }
}