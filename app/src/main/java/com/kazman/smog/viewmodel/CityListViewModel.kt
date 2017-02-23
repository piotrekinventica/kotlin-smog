package com.kazman.smog.viewmodel

import android.databinding.BaseObservable
import android.view.View
import com.kazman.smog.model.CityListModel

/**
 * Created by piotrkazmierczak on 14.02.2017.
 */
class CityListViewModel : BaseObservable() {
    val cityListModel = CityListModel()

    fun onClick(view: View) {
        cityListModel.downloadCityList()
    }
}
