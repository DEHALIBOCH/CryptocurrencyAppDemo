package com.demoapp.cleanarchdemo.data.remote

import com.demoapp.cleanarchdemo.data.remote.data_transfer_object.CoinDTO
import com.demoapp.cleanarchdemo.data.remote.data_transfer_object.CoinDetailsDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    /**
     *  Возвращает все монеты с Api
     */
    @GET("/v1/coins")
    suspend fun getAllCoins(): List<CoinDTO>


    /**
     *  Возвращает информацию о одной монете используя id этой монеты
     */
    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailsDTO

}
