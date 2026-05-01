package com.charlesmccullough

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.charlesmccullough.coins.presentation.screens.CoinsListScreen
import com.charlesmccullough.theme.CoinRoutineTheme

@Composable
@Preview
fun App() {
    CoinRoutineTheme {
        CoinsListScreen { }
    }
}