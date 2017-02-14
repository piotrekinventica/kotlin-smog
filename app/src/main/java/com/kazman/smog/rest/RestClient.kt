package com.kazman.smog.rest

import android.content.Context
import com.kazman.smog.R
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by piotrkazmierczak on 07.02.2017.
 */


class RestClient(val context: Context) {

    val apiRequests: ApiRequests

    init {
        val interceptor = HttpLoggingInterceptor().apply { this.level = HttpLoggingInterceptor.Level.BODY }
        val okHttpClient = OkHttpClient.Builder().apply { this.addInterceptor(interceptor) }.build()
        val retrofit = Retrofit.Builder().client(okHttpClient).baseUrl(context.getString(R.string.api_url)).addConverterFactory(MoshiConverterFactory.create()).build()

        apiRequests = retrofit.create(ApiRequests::class.java)
    }
}
