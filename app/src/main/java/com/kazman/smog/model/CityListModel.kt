package com.kazman.smog.model

import com.kazman.smog.cachedCityList
import com.kazman.smog.di.Injector
import com.kazman.smog.edit
import com.kazman.smog.rest.model.City
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
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
                    Injector.component?.getPreferences()?.edit {
                        val type = Types.newParameterizedType(List::class.java, City::class.java)
                        val jsonAdapter: JsonAdapter<List<City>> = Moshi.Builder().build().adapter(type)
                        putString(cachedCityList, jsonAdapter.toJson(cityList))
                    }
                }, Throwable::printStackTrace)
    }
}
