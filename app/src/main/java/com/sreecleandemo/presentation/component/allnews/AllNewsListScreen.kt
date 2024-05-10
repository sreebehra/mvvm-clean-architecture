package com.sreecleandemo.presentation.component.allnews

//import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.sreecleandemo.domain.model.Article

@Composable
fun NewsListScreen(viewModel: AllNewsListViewModel = hiltViewModel()) {
    val res = viewModel.newsList.value

    if (res.isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

    if (res.error.isNotEmpty()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = res.error,
                style = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 20.sp)
            )
        }
    }

    res.data?.let {
        LazyColumn(
            modifier = Modifier.background(color = Color.Gray),
            verticalArrangement = Arrangement.spacedBy(8.dp),

            )
        {
            items(it) {
                NewsItem(it)
            }
        }
    }
}

@Composable
fun NewsItem(it: Article) {
    Column(modifier = Modifier.background(Color.White)) {

        AsyncImage(
            model = it.url, contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        Text(
            text = it.title,
            style = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 16.sp),
//            textAlign = TextAlign.Center,
            modifier = Modifier.padding(10.dp)
        )

    }
}


//for latest hilt with navigation and get viewmodel
//https://developer.android.com/jetpack/compose/libraries#hilt-navigation