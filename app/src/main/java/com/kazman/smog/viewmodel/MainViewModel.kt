package com.kazman.smog.viewmodel

import android.databinding.BaseObservable
import android.util.Log
import android.view.View
import com.kazman.smog.di.Injector
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by piotrkazmierczak on 14.02.2017.
 */
class MainViewModel : BaseObservable() {
    fun onClick(view: View) {
        val cities = Injector.component?.getApiRequests()?.cities()
        cities?.subscribeOn(Schedulers.io())?.
                observeOn(AndroidSchedulers.mainThread())?.
                subscribe({
                    list ->
                    Log.e("TAG", list.toString())
                }, Throwable::printStackTrace)
    }
}
