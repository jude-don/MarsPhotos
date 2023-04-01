package com.example.marsphotos.datamodels

import com.google.gson.annotations.SerializedName

data class MarsPhotos(

	@SerializedName("id")
	val id: String,

	@SerializedName("img_src")
	val imgSrc: String
)
