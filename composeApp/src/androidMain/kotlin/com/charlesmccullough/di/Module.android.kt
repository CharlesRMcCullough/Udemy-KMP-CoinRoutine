package com.charlesmccullough.di

import androidx.room.RoomDatabase
import com.charlesmccullough.core.database.getPortfolioDatabaseBuilder
import com.charlesmccullough.core.database.portfolio.PortfolioDatabase
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.android.Android
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

actual val platformModule = module {

    // core
    single<HttpClientEngine> { Android.create() }
    singleOf(::getPortfolioDatabaseBuilder).bind<RoomDatabase.Builder<PortfolioDatabase>>()
}