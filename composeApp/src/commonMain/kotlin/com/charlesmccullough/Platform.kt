package com.charlesmccullough

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform