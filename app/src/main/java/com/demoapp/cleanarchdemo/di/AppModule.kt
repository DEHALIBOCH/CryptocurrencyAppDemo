package com.demoapp.cleanarchdemo.di

import androidx.compose.ui.unit.Constraints
import com.demoapp.cleanarchdemo.common.Constants
import com.demoapp.cleanarchdemo.data.remote.CoinApi
import com.demoapp.cleanarchdemo.data.repository.CoinRepositoryImpl
import com.demoapp.cleanarchdemo.domain.repository.CoinRepository
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
    fun provideCoinApi(): CoinApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}