package com.demoapp.cleanarchdemo.domain.repository

import com.demoapp.cleanarchdemo.data.remote.dto.CoinDetailDto
import com.demoapp.cleanarchdemo.data.remote.dto.CoinDto

interface CoinRepository {

    /**
     * Метод для получения листа крипто-монет содержащих основную информацию
     */
    suspend fun getCoins(): List<CoinDto>

    /**
     * Метод для получения крипто-монеты содержащей подробную информацию, используя id данной монеты
     */
    suspend fun getCoinById(coinId: String): CoinDetailDto
}