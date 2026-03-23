package com.example.adgrid

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform