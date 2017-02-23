package com.kazman.smog.viewmodel

import android.databinding.BaseObservable
import android.view.View
import com.kazman.smog.adapter.AbstractRecyclerAdapter
import com.kazman.smog.model.CityListModel

/**
 * Created by piotrkazmierczak on 14.02.2017.
 */
class CityListViewModel : BaseObservable(), ViewModel {
    val cityListModel = CityListModel()
    var listAdapter: AbstractRecyclerAdapter? = null

    fun onClick(view: View) {
        cityListModel.downloadCityList()
    }

    override fun onCreate() {
    }

    override fun onDestroy() {
    }

    override fun onPause() {
    }

    override fun onResume() {
    }

}
