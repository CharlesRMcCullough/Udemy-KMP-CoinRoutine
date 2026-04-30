package com.charlesmccullough.di

import com.charlesmccullough.coins.data.remote.KtorCoinsRemoteDataSource
import com.charlesmccullough.coins.domain.GetCoinDetailUseCase
import com.charlesmccullough.coins.domain.GetCoinsListUseCase
import com.charlesmccullough.coins.domain.api.CoinsRemoteDataSource
import com.charlesmccullough.coins.presentation.CoinsListViewModel
import com.charlesmccullough.core.network.HttpClientFactory
import io.ktor.client.HttpClient
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.bind
import org.koin.dsl.module

fun initKoin(config: KoinAppDeclaration? = null) =
    startKoin {
        config?.invoke(this)
        modules(
            sharedModule,
            platformModule,
        )
    }


expect val platformModule: Module

val sharedModule = module {

    // core
    single<HttpClient> { HttpClientFactory.create(get()) }
    viewModel { CoinsListViewModel(get()) }
    singleOf(::GetCoinsListUseCase)
    singleOf(::KtorCoinsRemoteDataSource).bind<CoinsRemoteDataSource>()
    singleOf(::GetCoinDetailUseCase)
}