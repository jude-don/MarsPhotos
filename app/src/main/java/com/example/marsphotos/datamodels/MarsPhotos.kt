package com.example.marsphotos.datamodels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity(tableName = "photos")
@Serializable
data class MarsPhotos(

	@PrimaryKey
	@ColumnInfo(name = "id")
	@SerialName("id")
	val id: String,

	@ColumnInfo(name="img_src")
	@SerialName("img_src")
	val imgSrc: String
)
