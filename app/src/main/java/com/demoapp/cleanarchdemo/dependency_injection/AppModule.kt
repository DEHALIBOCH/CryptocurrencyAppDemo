package com.demoapp.cleanarchdemo.dependency_injection

import com.demoapp.cleanarchdemo.common.Constants
import com.demoapp.cleanarchdemo.data.remote.CoinPaprikaApi
import com.demoapp.cleanarchdemo.data.repositories.CoinRepositoryImplementation
import com.demoapp.cleanarchdemo.domain.repositories.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCoinPaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImplementation(api)
    }
}