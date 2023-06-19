package com.demoapp.cleanarchdemo.domain.repositories

import com.demoapp.cleanarchdemo.data.remote.data_transfer_object.CoinDTO
import com.demoapp.cleanarchdemo.data.remote.data_transfer_object.CoinDetailsDTO

interface CoinRepository {

    suspend fun getAllCoins(): List<CoinDTO>

    suspend fun getCoinById(coinId: String): CoinDetailsDTO
}