package com.kazman.smog.rest

import android.os.Build
import com.kazman.smog.appVersionName
import com.kazman.smog.di.Injector
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by piotrkazmierczak on 23.02.2017.
 */


class RequestInterceptor : Interceptor {


    override fun intercept(chain: Interceptor.Chain?): Response {
        val request = chain?.request()?.newBuilder()
                ?.addHeader("User-Agent", "Android/${Build.VERSION.SDK_INT} version ${Injector.component?.getContext()?.appVersionName()}")?.build()
        return chain!!.proceed(request)
    }
}
