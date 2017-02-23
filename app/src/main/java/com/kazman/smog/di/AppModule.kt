package com.kazman.smog.di

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.kazman.smog.R
import com.kazman.smog.rest.ApiRequests
import com.kazman.smog.rest.RequestInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * Created by piotrkazmierczak on 23.02.2017.
 */

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideApiRequests(context: Context): ApiRequests {
        val interceptor = HttpLoggingInterceptor().apply { this.level = HttpLoggingInterceptor.Level.BODY }
        val requestInterceptor = RequestInterceptor()
        val okHttpClient = OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)
            this.addInterceptor(requestInterceptor)
        }.build()
        val retrofit = Retrofit.Builder().apply {
            client(okHttpClient)
            baseUrl(context.getString(R.string.api_url))
            addConverterFactory(MoshiConverterFactory.create())
            addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        }.build()

        return retrofit.create(ApiRequests::class.java)
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }
}
