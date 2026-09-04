package com.example.travelappui

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform