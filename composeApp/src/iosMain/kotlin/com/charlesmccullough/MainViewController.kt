package com.charlesmccullough

import androidx.compose.ui.window.ComposeUIViewController
import com.charlesmccullough.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }