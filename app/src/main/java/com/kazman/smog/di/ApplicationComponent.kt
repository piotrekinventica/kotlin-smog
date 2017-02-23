package com.kazman.smog.di

import android.content.Context
import android.content.SharedPreferences
import android.content.pm.PackageManager
import com.kazman.smog.rest.ApiRequests
import dagger.Component
import javax.inject.Singleton

/**
 * Created by piotrkazmierczak on 23.02.2017.
 */

@Singleton
@Component(modules = arrayOf(AndroidModule::class, AppModule::class))
interface ApplicationComponent {
    fun getContext(): Context
    fun getApiRequests(): ApiRequests
    fun getPreferences(): SharedPreferences
    fun getPackageManager(): PackageManager
}
