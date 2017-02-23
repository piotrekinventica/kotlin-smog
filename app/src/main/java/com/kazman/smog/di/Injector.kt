package com.kazman.smog.di

import android.app.Application

/**
 * Created by piotrkazmierczak on 23.02.2017.
 */

class Injector {
    companion object {
        var component: ApplicationComponent? = null
        fun start(application: Application) {
            component = DaggerApplicationComponent.builder().androidModule(AndroidModule(application)).appModule(AppModule()).build()
        }
    }
}
