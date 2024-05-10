package com.sreecleandemo.domain.model

data class NewsListState(
    val isLoading:Boolean=false,
    val error:String="",
    val data:List<Article>?=null
)
