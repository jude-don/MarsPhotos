package com.example.marsphotos.network.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName

@Entity(tableName = "photos")
data class LocalMarsPhotos(
  @PrimaryKey
  @ColumnInfo(name = "id")
    val id: String,
  @ColumnInfo(name="img_src")
    val imgSrc: String
)
