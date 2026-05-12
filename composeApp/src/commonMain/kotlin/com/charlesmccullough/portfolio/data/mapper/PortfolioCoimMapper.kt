package com.charlesmccullough.portfolio.data.mapper

import com.charlesmccullough.core.domain.coin.Coin
import com.charlesmccullough.portfolio.data.local.PortfolioCoinEntity
import com.charlesmccullough.portfolio.domain.PortfolioCoinModel
import kotlin.time.Clock

fun PortfolioCoinEntity.toPortfolioCoinModel(
    currentPrice: Double,
): PortfolioCoinModel {
    return PortfolioCoinModel(
        coin = Coin(
            id = coinId,
            name = name,
            symbol = symbol,
            iconUrl = iconUrl
        ),
        performancePercent = ((currentPrice - averagePurchasePrice) / averagePurchasePrice) * 100,
        averagePurchasePrice = averagePurchasePrice,
        ownedAmountInUnits = amountOwned,
        ownedAmountInFiat = amountOwned * currentPrice,
    )
}

fun PortfolioCoinModel.toPortfolioCoinEntity(): PortfolioCoinEntity {
    return PortfolioCoinEntity(
        coinId = coin.id,
        name = coin.name,
        symbol = coin.symbol,
        iconUrl = coin.iconUrl,
        amountOwned = ownedAmountInUnits,
        averagePurchasePrice = averagePurchasePrice,
        timestamp = Clock.System.now().toEpochMilliseconds()
    )
}

