package com.kazman.smog.viewmodel

/**
 * Created by piotrkazmierczak on 23.02.2017.
 */
interface ViewModel {
    fun onCreate()
    fun onPause()
    fun onResume()
    fun onDestroy()
}
