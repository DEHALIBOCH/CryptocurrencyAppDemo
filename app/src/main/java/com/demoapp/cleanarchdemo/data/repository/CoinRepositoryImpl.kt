package com.demoapp.cleanarchdemo.data.repository

import com.demoapp.cleanarchdemo.data.remote.CoinApi
import com.demoapp.cleanarchdemo.data.remote.dto.CoinDetailDto
import com.demoapp.cleanarchdemo.data.remote.dto.CoinDto
import com.demoapp.cleanarchdemo.domain.model.Coin
import com.demoapp.cleanarchdemo.domain.model.CoinDetail
import com.demoapp.cleanarchdemo.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinApi
) : CoinRepository {

    override suspend fun getCoins(): List<Coin> {
        return api.getCoins().map { it.toCoin() }
    }

    override suspend fun getCoinById(coinId: String): CoinDetail {
        return api.getCoinById(coinId).toCoinDetail()
    }
}