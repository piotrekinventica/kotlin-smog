package com.kazman.smog.rest

import com.kazman.smog.rest.model.ApiResponse
import com.kazman.smog.rest.model.City
import com.kazman.smog.rest.model.Station
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by piotrkazmierczak on 07.02.2017.
 */
interface ApiRequests {

    @GET("/cities")
    fun cities(): Single<ApiResponse<City>>

    @GET("/cities/{city}")
    fun city(@Path("city") city: String): City

    @GET("/stations/nearby")
    fun nearbyStations(@Query("longitude") lng: Long, @Query("latitude") lat: Long): Call<ApiResponse<Station>>

    @GET("/cities/{city}/stations")
    fun stationsInCity(@Path("city") city: String): Call<ApiResponse<Station>>

    @GET("/cities/{city}/stations/{station}")
    fun singleStationInCity(@Path("city") city: String, @Path("station") stations: String): Station

}
