package com.kazman.smog

import android.app.Application
import com.kazman.smog.di.Injector
import jp.wasabeef.takt.Takt

/**
 * Created by piotrkazmierczak on 14.02.2017.
 */
class SmogApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Takt.stock(this).play()
        }
        Injector.start(this)
    }

    override fun onTerminate() {
        if (BuildConfig.DEBUG) {
            Takt.finish()
        }
        super.onTerminate()
    }
}
