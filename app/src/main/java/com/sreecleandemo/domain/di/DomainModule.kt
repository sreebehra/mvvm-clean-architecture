package com.sreecleandemo.domain.di

import com.sreecleandemo.domain.repository.NewsRepository
import com.sreecleandemo.domain.usecase.GetAllNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun provideGetAllNewsUseCase(newsRepository: NewsRepository): GetAllNewsUseCase {
        return GetAllNewsUseCase(newsRepository = newsRepository)
    }
}