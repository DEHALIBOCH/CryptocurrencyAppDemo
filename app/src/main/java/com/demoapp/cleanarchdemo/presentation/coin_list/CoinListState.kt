package com.demoapp.cleanarchdemo.presentation.coin_list

import com.demoapp.cleanarchdemo.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = "",
)
