package com.kazman.smog.viewmodel

import android.databinding.BaseObservable
import android.util.Log
import android.view.View
import com.kazman.smog.rest.RestClient
import com.kazman.smog.rest.model.ApiResponse
import com.kazman.smog.rest.model.City
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by piotrkazmierczak on 14.02.2017.
 */
class MainViewModel : BaseObservable() {
    fun onClick(view: View) {
        val cities = RestClient().apiRequests.cities();
        cities.enqueue(object : Callback<ApiResponse<City>> {
            override fun onFailure(call: Call<ApiResponse<City>>?, t: Throwable?) {
                t?.printStackTrace()
            }

            override fun onResponse(call: Call<ApiResponse<City>>?, response: Response<ApiResponse<City>>?) {
                Log.e("TAG", response?.body()?._embedded?.records.toString())
            }
        })
    }
}
