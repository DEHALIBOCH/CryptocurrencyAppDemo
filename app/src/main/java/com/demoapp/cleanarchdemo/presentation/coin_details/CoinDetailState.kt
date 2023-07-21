package com.demoapp.cleanarchdemo.presentation.coin_details

import com.demoapp.cleanarchdemo.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = "",
)