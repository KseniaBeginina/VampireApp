package com.beginina.data.dto

data class TelegramUserDto(
    val id: String,
    val first_name: String,
    val last_name: String,
    val username: String,
    val photo_url: String,
    val auth_date: Int,
    val hash: String
)
