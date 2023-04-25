package com.example.marsphotos.network.local

import com.example.marsphotos.datamodels.MarsPhotos
import kotlinx.coroutines.flow.Flow

interface MarsRepository {

    suspend fun insertData()

    suspend fun getData(): List<MarsPhotos>

}