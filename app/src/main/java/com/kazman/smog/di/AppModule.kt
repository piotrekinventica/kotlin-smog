package com.kazman.smog.di

import android.content.Context
import com.kazman.smog.R
import com.kazman.smog.rest.ApiRequests
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
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
        val okHttpClient = OkHttpClient.Builder().apply { this.addInterceptor(interceptor) }.build()
        val retrofit = Retrofit.Builder().apply {
            client(okHttpClient)
            baseUrl(context.getString(R.string.api_url))
            addConverterFactory(MoshiConverterFactory.create())
            addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        }.build()

        return retrofit.create(ApiRequests::class.java)
    }
}
