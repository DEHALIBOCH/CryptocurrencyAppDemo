package com.demoapp.cleanarchdemo.presentation.coin_details

import com.demoapp.cleanarchdemo.domain.models.CoinDetails

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetails? = null,
    val error: String = "",
)