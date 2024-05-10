package com.sreecleandemo.data.dto

import com.sreecleandemo.domain.model.Article

data class ArticleDto(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
)

fun ArticleDto.toDomain(): Article {
    return Article(
        author = author?:"",
        description = description?:"",
        publishedAt = publishedAt?:"",
        title = title?:"",
        url = urlToImage?:""
    )
}