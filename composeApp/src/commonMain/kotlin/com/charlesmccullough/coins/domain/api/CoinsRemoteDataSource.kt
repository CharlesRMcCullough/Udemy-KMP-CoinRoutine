package com.charlesmccullough.coins.domain.api

import com.charlesmccullough.coins.data.remote.dto.CoinDetailsResponseDto
import com.charlesmccullough.coins.data.remote.dto.CoinPriceHistoryResponseDto
import com.charlesmccullough.coins.data.remote.dto.CoinsResponseDto
import com.charlesmccullough.core.domain.DataError
import com.charlesmccullough.core.domain.Result

interface CoinsRemoteDataSource {

        suspend fun getListOfCoins(): Result<CoinsResponseDto, DataError.Remote>

        suspend fun getPriceHistory(coinId: String): Result<CoinPriceHistoryResponseDto, DataError.Remote>

        suspend fun getCoinById(coinId: String): Result<CoinDetailsResponseDto, DataError.Remote>
    }
