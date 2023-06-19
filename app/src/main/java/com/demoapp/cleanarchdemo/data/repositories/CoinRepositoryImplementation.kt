package com.demoapp.cleanarchdemo.data.repositories

import com.demoapp.cleanarchdemo.data.remote.CoinPaprikaApi
import com.demoapp.cleanarchdemo.data.remote.data_transfer_object.CoinDTO
import com.demoapp.cleanarchdemo.data.remote.data_transfer_object.CoinDetailsDTO
import com.demoapp.cleanarchdemo.domain.repositories.CoinRepository
import javax.inject.Inject

class CoinRepositoryImplementation @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getAllCoins(): List<CoinDTO> {
        return api.getAllCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailsDTO {
        return api.getCoinById(coinId)
    }
}