package com.demoapp.cleanarchdemo.domain.repository

import com.demoapp.cleanarchdemo.domain.model.Coin
import com.demoapp.cleanarchdemo.domain.model.CoinDetail

interface CoinRepository {

    /**
     * Метод для получения листа крипто-монет содержащих основную информацию
     */
    suspend fun getCoins(): List<Coin>

    /**
     * Метод для получения крипто-монеты содержащей подробную информацию, используя id данной монеты
     */
    suspend fun getCoinById(coinId: String): CoinDetail
}