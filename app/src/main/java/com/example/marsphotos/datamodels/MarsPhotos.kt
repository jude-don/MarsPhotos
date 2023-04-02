package com.example.marsphotos.datamodels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MarsPhotos(

	@SerialName("id")
	val id: String,

	@SerialName("img_src")
	val imgSrc: String
)
