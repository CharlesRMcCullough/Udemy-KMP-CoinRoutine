package com.charlesmccullough.core.database.portfolio

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import com.charlesmccullough.portfolio.data.local.PortfolioCoinEntity
import com.charlesmccullough.portfolio.data.local.PortfolioDao
import com.charlesmccullough.portfolio.data.local.UserBalanceDao
import com.charlesmccullough.portfolio.data.local.UserBalanceEntity

@Database(entities = [PortfolioCoinEntity::class, UserBalanceEntity::class], version = 2)
@ConstructedBy(PortfolioDatabaseCreator::class)
abstract class PortfolioDatabase: RoomDatabase() {
    abstract fun portfolioDao(): PortfolioDao
    abstract fun userBalanceDai(): UserBalanceDao
}

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object PortfolioDatabaseCreator : RoomDatabaseConstructor<PortfolioDatabase> {
    override fun initialize(): PortfolioDatabase
}
