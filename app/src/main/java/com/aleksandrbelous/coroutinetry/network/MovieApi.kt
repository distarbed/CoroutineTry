package com.aleksandrbelous.coroutinetry.network


import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author Aleksandr Belous
 * @since 7/10/20.
 */

private val service: MovieApi by lazy {
    val okHttpClient = OkHttpClient.Builder()
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("http://omdbapi.com")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    retrofit.create(MovieApi::class.java)
}

fun getNetworkService() = service

interface MovieApi {
    //search for some items
    @GET("/")
    suspend fun search(@Query("apikey") apikey: String, @Query("s") query: String): SearchResponse
}
