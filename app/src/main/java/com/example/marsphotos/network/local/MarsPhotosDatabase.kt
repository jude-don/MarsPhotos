package com.example.marsphotos.network.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.marsphotos.datamodels.MarsPhotos


@Database(
    entities = [MarsPhotos::class],
    version = 2,
    exportSchema = false
)

abstract class MarsPhotosDatabase:RoomDatabase() {
    abstract val dao:MarsDao
}