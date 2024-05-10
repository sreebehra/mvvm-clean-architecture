package com.sreecleandemo.data.network

import com.sreecleandemo.data.dto.ArticleDto
import com.sreecleandemo.data.dto.NewsResponse
import retrofit2.http.GET

//retrofit service
interface NewsAPIService {
    //https://saurav.tech/NewsAPI/everything/cnn.json
    //https://saurav.tech/NewsAPI/top-headlines/category/health/in.json
    @GET("everything/cnn.json")
//    suspend fun getAllNews():List<ArticleDto>
    suspend fun getAllNews():NewsResponse

    @GET("top-headlines/category/health/in.json")
    suspend fun getHealthHeadlines():List<ArticleDto>
}