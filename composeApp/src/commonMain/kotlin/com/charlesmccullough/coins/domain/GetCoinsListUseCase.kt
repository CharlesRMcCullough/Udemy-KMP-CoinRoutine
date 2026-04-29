package com.charlesmccullough.coins.domain

import com.charlesmccullough.coins.data.mapper.toCoinModel
import com.charlesmccullough.coins.domain.api.CoinsRemoteDataSource
import com.charlesmccullough.coins.domain.model.CoinModel
import com.charlesmccullough.core.domain.DataError
import com.charlesmccullough.core.domain.Result
import com.charlesmccullough.core.domain.map

class GetCoinsListUseCase(
    private val client: CoinsRemoteDataSource
) {
    suspend fun execute(): Result<List<CoinModel>, DataError.Remote> {
        return client.getListOfCoins().map { dto ->
            dto.data.coins.map { it.toCoinModel() }
        }
    }
}