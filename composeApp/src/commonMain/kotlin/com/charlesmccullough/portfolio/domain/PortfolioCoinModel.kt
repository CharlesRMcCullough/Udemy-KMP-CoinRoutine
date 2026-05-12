package com.charlesmccullough.portfolio.domain

import com.charlesmccullough.core.domain.coin.Coin

data class PortfolioCoinModel(
    val coin: Coin,
    val performancePercent: Double,
    val averagePurchasePrice: Double,
    val ownedAmountInUnits: Double,
    val ownedAmountInFiat: Double

    )
