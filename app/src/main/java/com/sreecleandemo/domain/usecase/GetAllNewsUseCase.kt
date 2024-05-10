package com.sreecleandemo.domain.usecase

import com.sreecleandemo.common.Resource
import com.sreecleandemo.domain.model.Article
import com.sreecleandemo.domain.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetAllNewsUseCase @Inject constructor(val newsRepository: NewsRepository) {
    operator fun invoke(): Flow<Resource<List<Article>>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = newsRepository.getAllNews()))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message.toString()))
        }
    }.flowOn(Dispatchers.IO) //** Keep in mind
}