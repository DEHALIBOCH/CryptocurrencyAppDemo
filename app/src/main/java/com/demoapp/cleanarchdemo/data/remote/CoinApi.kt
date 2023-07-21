package com.demoapp.cleanarchdemo.data.remote

import com.demoapp.cleanarchdemo.data.remote.dto.CoinDetailDto
import com.demoapp.cleanarchdemo.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApi {

    /**
     * Делает запрос в API и возвращает лист содержащий информацию о коинах
     */
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    /**
     * Делает запрос в API и возвращает подробную информацию о коине используя его id
     */
    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String) : CoinDetailDto
}