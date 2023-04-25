package com.example.marsphotos.network.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.marsphotos.datamodels.MarsPhotos
import kotlinx.coroutines.flow.Flow

@Dao
interface MarsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(photos:List<MarsPhotos>)


    @Query("SELECT * FROM photos")
   fun getData(): List<MarsPhotos>

}