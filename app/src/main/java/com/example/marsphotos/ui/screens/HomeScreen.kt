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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.marsphotos.R
import com.example.marsphotos.datamodels.MarsPhotos
import com.example.marsphotos.ui.theme.MarsPhotosTheme

@Composable
fun HomeScreen(
    marsUiState: MarsUiState,
    modifier: Modifier = Modifier
) {
    when (marsUiState){
        is MarsUiState.Success -> ResultScreen(marsUiState.listOfObjectPhotos, modifier)
        is MarsUiState.Loading -> LoadingScreen(modifier)
        is MarsUiState.Error -> ErrorScreen(modifier)
    }

}

/**
 * The home screen displaying result of fetching photos.
 */
@Composable
fun ResultScreen(marsUiState: List<MarsPhotos>, modifier: Modifier = Modifier) {
    LazyColumn(){
        items(marsUiState.size){
            itemList(image_url = marsUiState[it].imgSrc, modifier = modifier)
        }
    }

}


@Composable
fun itemList(image_url:String, modifier: Modifier){
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = rememberAsyncImagePainter(image_url),
            contentDescription = null,
            modifier = Modifier.size(128.dp)
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
