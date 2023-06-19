package com.demoapp.cleanarchdemo.domain.models

import com.demoapp.cleanarchdemo.data.remote.data_transfer_object.TeamMember

/**
 * Класс содержащий только необходимую информацию о деталях монеты.
 */
data class CoinDetails(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>,
)
