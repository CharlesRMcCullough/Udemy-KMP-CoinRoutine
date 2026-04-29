package com.charlesmccullough.coins.domain

import com.charlesmccullough.coins.data.mapper.toCoinModel
import com.charlesmccullough.coins.domain.api.CoinsRemoteDataSource
import com.charlesmccullough.coins.domain.model.CoinModel
import com.charlesmccullough.core.domain.DataError
import com.charlesmccullough.core.domain.Result
import com.charlesmccullough.core.domain.map

class GetCoinDetailUseCase(
    private val client: CoinsRemoteDataSource
) {
    suspend fun execute(coinId: String): Result<CoinModel, DataError.Remote> {
        return client.getCoinById(coinId).map { dto ->
            dto.data.coin.toCoinModel()
        }
    }
}