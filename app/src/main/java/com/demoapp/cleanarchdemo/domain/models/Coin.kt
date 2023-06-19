package com.demoapp.cleanarchdemo.domain.models

/**
 *  Класс содержащий только необходимые данные
 */
data class Coin(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)