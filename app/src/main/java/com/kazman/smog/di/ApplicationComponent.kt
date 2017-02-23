package com.kazman.smog.di

import android.content.Context
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
}
