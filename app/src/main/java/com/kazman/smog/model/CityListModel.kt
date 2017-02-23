package com.kazman.smog.model

import android.util.Log
import com.kazman.smog.di.Injector
import com.kazman.smog.rest.model.City
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by piotrkazmierczak on 23.02.2017.
 */

class CityListModel {
    var cityList: List<City>? = null

    fun downloadCityList() {
        Injector.component?.getApiRequests()?.cities()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe({
                    list ->
                    cityList = list._embedded.records
                    Log.e("TAG", cityList.toString())
                }, Throwable::printStackTrace)
    }
}
