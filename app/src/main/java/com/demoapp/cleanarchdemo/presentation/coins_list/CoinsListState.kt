package com.demoapp.cleanarchdemo.presentation.coins_list

import com.demoapp.cleanarchdemo.domain.models.Coin

data class CoinsListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = "",
)