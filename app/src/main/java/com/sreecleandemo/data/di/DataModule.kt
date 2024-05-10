package com.sreecleandemo.data.di

import com.sreecleandemo.common.Constants
import com.sreecleandemo.data.network.NewsAPIService
import com.sreecleandemo.data.repository.NewsRepositoryImpl
import com.sreecleandemo.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): NewsAPIService {
        return retrofit.create(NewsAPIService::class.java)
    }

    @Provides
    fun provideNewsRepo(newsAPIService: NewsAPIService):NewsRepository{
        return NewsRepositoryImpl(newsAPIService)
    }

// Binds works just like above code to get repository instance where interface newsAPIServe
// get bind with NewsRepositoryImpl
//    @Binds
//    abstract fun bindNewsAPIService(newsRepositoryImpl: NewsRepositoryImpl): NewsAPIService
}