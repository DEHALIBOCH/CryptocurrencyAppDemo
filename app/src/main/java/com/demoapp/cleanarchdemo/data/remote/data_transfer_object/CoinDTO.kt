package com.demoapp.cleanarchdemo.data.remote.data_transfer_object

import com.demoapp.cleanarchdemo.domain.models.Coin
import com.google.gson.annotations.SerializedName

/**
 * Содержит все данные прилетающие в запросе. Класс который содержит данные которые нам,
 * действительно необходимы(т.е. класс без лишних данных) необходимо создать в domain слое.
 */
data class CoinDTO(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String,
)

fun CoinDTO.toCoin(): Coin {
    return Coin(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}