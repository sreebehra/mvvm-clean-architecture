package com.sreecleandemo.data.repository

import com.sreecleandemo.data.dto.toDomain
import com.sreecleandemo.data.network.NewsAPIService
import com.sreecleandemo.domain.model.Article
import com.sreecleandemo.domain.repository.NewsRepository

class NewsRepositoryImpl(private val newsAPI: NewsAPIService) : NewsRepository {
    override suspend fun getAllNews(): List<Article> {
        return newsAPI.getAllNews().articles.map { it.toDomain() } //Check articles here
    }

    override suspend fun getHealthNews(): List<Article> {
        TODO("Not yet implemented")
    }
}