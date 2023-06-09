/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.marsphotos.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.marsphotos.datamodels.MarsPhotos

@Composable
fun HomeScreen(
    viewModel: MarsViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    when (val state = viewModel.marsUiState){
        is MarsUiState.Success -> ResultScreen(state.photos, modifier)
        is MarsUiState.Loading -> LoadingScreen(modifier)
        is MarsUiState.Error -> ErrorScreen(modifier)
    }

}

/**
 * The home screen displaying result of fetching photos.
 */
@Composable
fun ResultScreen(marsUiState: List<MarsPhotos>, modifier: Modifier = Modifier) {
var number = 1
    
    LazyColumn(){
        itemsIndexed(marsUiState){
            index,item->
            number = index + 1
            itemList(
                image_url = item.imgSrc,
                modifier = modifier,
                itemname = number,

            )
        }
    }

}


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun itemList(image_url:String, modifier: Modifier,itemname:Int){
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
//        Image(
//            painter = rememberAsyncImagePainter(image_url),
//            contentDescription = null,
//            modifier = Modifier.size(300.dp)
//        )
        //Glide is the best to load images
        AsyncImage(
            model = image_url,
            contentDescription = "Mars Photo",
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(300.dp)
        )
//        Image(
//            painter = rememberAsyncImagePainter(image_url),
//            contentDescription = "Mars Photo",
//            contentScale = ContentScale.Fit,
//            modifier = Modifier.size(300.dp)
//        )
        Text(
            text = "Photo $itemname",
            color = Color.White,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 30.dp)
                .background(Color.Black)
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ResultScreenPreview() {
//    MarsPhotosTheme {
//        ResultScreen(stringResource(R.string.placeholder_result))
//    }
//}
