package com.example.marsphotos.network

import com.example.marsphotos.datamodels.MarsPhotos
import com.example.marsphotos.ui.screens.MarsUiState
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


interface MarsApiService {

    @GET("/photos")
    suspend fun getPhotos():Call<List<MarsPhotos>>
}

object MarsApi{
    /* Remember "lazy initialization" is when object creation is purposely delayed,
    until you actually need that object, to avoid unnecessary computation or use
    of other computing resources. Kotlin has first-class support for lazy instantiation. */

    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }

}
