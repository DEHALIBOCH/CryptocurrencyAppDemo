package com.demoapp.cleanarchdemo.data.repository

import com.demoapp.cleanarchdemo.data.remote.CoinApi
import com.demoapp.cleanarchdemo.data.remote.dto.CoinDetailDto
import com.demoapp.cleanarchdemo.data.remote.dto.CoinDto
import com.demoapp.cleanarchdemo.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}