package com.example.marsphotos.network.local

import com.example.marsphotos.datamodels.MarsPhotos
import com.example.marsphotos.network.MarsApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.net.ConnectException
import java.net.UnknownHostException
import javax.inject.Inject

class MarsRepositoryImpl @Inject constructor(
    private val dao: MarsDao,
    private val restInterface:MarsApiService
    ) : MarsRepository {

    override suspend fun insertData() {
        dao.insertData(restInterface.getPhotos()
//            .map {
//            LocalMarsPhotos(
//                it.id,
//                it.imgSrc
//            )
//        }
        )
    }


    override suspend fun getData(): List<MarsPhotos> {

            try {
                return when(dao.getData().isEmpty()) {
                    true -> {
                        dao.insertData(restInterface.getPhotos())
                        restInterface.getPhotos()
            //                            .map {
            //                            LocalMarsPhotos(
            //                                it.id,
            //                                it.imgSrc
            //                            )
            //                        }
                    } false -> {
                        dao.getData()
                    }
                }
            }
            catch (e: Exception) {
                when (e) {
                    is UnknownHostException,
                    is ConnectException,
                    is HttpException,
                    -> {
                        throw Exception(
                            "Something went wrong. " +
                                    "We have no data."
                        )
                    }
                }
                return emptyList()

            }
        }
    }
//        dao.insertData(restInterface.getPhotos())
//        println(dao.getData())
//        return withContext(Dispatchers.IO){
//            restInterface.getPhotos()
//        }

