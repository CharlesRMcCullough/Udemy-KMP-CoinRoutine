package com.charlesmccullough.coins.domain

import com.charlesmccullough.coins.data.mapper.toPriceModel
import com.charlesmccullough.coins.domain.api.CoinsRemoteDataSource
import com.charlesmccullough.coins.domain.model.PriceModel
import com.charlesmccullough.core.domain.DataError
import com.charlesmccullough.core.domain.Result
import com.charlesmccullough.core.domain.map

class GetCoinPriceHistoryUseCase(
    private val client: CoinsRemoteDataSource
) {
    suspend fun execute(coinId: String): Result<List<PriceModel>, DataError.Remote> {
        return client.getPriceHistory(coinId).map { dto ->
            dto.data.history.map { it.toPriceModel() }
        }
    }
}