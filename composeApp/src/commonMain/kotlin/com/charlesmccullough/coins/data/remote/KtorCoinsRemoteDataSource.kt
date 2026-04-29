package com.charlesmccullough.coins.data.remote

import com.charlesmccullough.BuildKonfig
import com.charlesmccullough.coins.data.remote.dto.CoinDetailsResponseDto
import com.charlesmccullough.coins.data.remote.dto.CoinPriceHistoryResponseDto
import com.charlesmccullough.coins.data.remote.dto.CoinsResponseDto
import com.charlesmccullough.coins.domain.api.CoinsRemoteDataSource
import com.charlesmccullough.core.domain.DataError
import com.charlesmccullough.core.network.safeCall
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import com.charlesmccullough.core.domain.Result

private val BASE_URL = BuildKonfig.BASE_URL

class KtorCoinsRemoteDataSource(
    private val httpClient: HttpClient
) : CoinsRemoteDataSource {

    override suspend fun getListOfCoins(): Result<CoinsResponseDto, DataError.Remote> {
        return safeCall {
            httpClient.get("$BASE_URL/coins")
        }
    }

    override suspend fun getPriceHistory(coinId: String): Result<CoinPriceHistoryResponseDto, DataError.Remote> {
        return safeCall {
            httpClient.get("$BASE_URL/coin/$coinId/history")
        }
    }

    override suspend fun getCoinById(coinId: String): Result<CoinDetailsResponseDto, DataError.Remote> {
        return safeCall {
            httpClient.get("$BASE_URL/coin/$coinId")
        }
    }
}