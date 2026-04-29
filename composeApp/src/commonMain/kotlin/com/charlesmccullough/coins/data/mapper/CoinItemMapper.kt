package com.charlesmccullough.coins.data.mapper

import com.charlesmccullough.coins.data.remote.dto.CoinItemDto
import com.charlesmccullough.coins.data.remote.dto.CoinPriceDto
import com.charlesmccullough.coins.domain.model.CoinModel
import com.charlesmccullough.coins.domain.model.PriceModel
import com.charlesmccullough.core.domain.coin.Coin

fun CoinItemDto.toCoinModel() = CoinModel(
    coin = Coin(
        id = uuid,
        name = name,
        symbol = symbol,
        iconUrl = iconUrl,
    ),
    price = price,
    change = change,
)

fun CoinPriceDto.toPriceModel() = PriceModel(
    price = price ?: 0.0,
    timestamp = timestamp
)