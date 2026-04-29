package com.charlesmccullough.coins.domain.model

import com.charlesmccullough.core.domain.coin.Coin

data class CoinModel(
    val coin: Coin,
    val price: Double,
    val change: Double
)
