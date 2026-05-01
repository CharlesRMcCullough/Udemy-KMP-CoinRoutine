package com.charlesmccullough.coins.presentation

import androidx.compose.runtime.Stable

@Stable
data class UiChartState(
    val sparkLine: List<Double> = emptyList(),
    val isLoading: Boolean,
    val coinName: String = ""

)
