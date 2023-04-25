package com.example.marsphotos.network

import com.example.marsphotos.datamodels.MarsPhotos
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()


interface MarsApiService {
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhotos>
    //suspend fun getPhotos():Call<List<MarsPhotos>>

}

object MarsApi{
    /* Remember "lazy initialization" is when object creation is purposely delayed,
    until you actually need that object, to avoid unnecessary computation or use
    of other computing resources. Kotlin has first-class support for lazy instantiation. */
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }

}
