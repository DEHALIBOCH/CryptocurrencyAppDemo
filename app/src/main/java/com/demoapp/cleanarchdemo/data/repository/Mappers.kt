package com.demoapp.cleanarchdemo.data.repository

import com.demoapp.cleanarchdemo.data.remote.dto.CoinDetailDto
import com.demoapp.cleanarchdemo.data.remote.dto.CoinDto
import com.demoapp.cleanarchdemo.domain.model.Coin
import com.demoapp.cleanarchdemo.domain.model.CoinDetail

/**
 *  Маппер из CoinDto(который мы получаем из API) в
 *  Coin(содержащий только необходимую нам информацию)
 */
fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}

/**
 *  Маппер из CoinDetailDto(который мы получаем из API) в
 *  CoinDetail(содержащий только необходимую нам информацию)
 */
fun CoinDetailDto.toCoinDetail(): CoinDetail {
    return CoinDetail(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = isActive,
        tags = tags.map { it.name },
        team = team
    )
}