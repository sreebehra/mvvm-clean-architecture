package com.sreecleandemo.domain.repository

import com.sreecleandemo.domain.model.Article

interface NewsRepository {

    suspend fun getAllNews():List<Article>

    suspend fun getHealthNews():List<Article>
}