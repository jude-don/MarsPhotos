package com.example.marsphotos.di

import android.content.Context
import androidx.room.Room
import com.example.marsphotos.network.BASE_URL
import com.example.marsphotos.network.MarsApiService
import com.example.marsphotos.network.local.MarsDao
import com.example.marsphotos.network.local.MarsPhotosDatabase
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /** Repository Functions */









    /** Room Provide Functions */

    @Provides
    fun provideRoomDao(database: MarsPhotosDatabase):MarsDao{
        return database.dao
    }

    @Singleton
    @Provides
    fun provideRoomDatabase(
        @ApplicationContext appContext:Context
    ):MarsPhotosDatabase{
        return Room.databaseBuilder(
            appContext,
            MarsPhotosDatabase::class.java,
            "photos_database"
        ).fallbackToDestructiveMigration().build()
    }








    /** Retrofit Provide Functions */
    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    fun provideRetrofitApi(retrofit: Retrofit): MarsApiService{
        return retrofit.create(MarsApiService::class.java)
    }





}