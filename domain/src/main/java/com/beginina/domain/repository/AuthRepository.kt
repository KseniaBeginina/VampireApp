package com.beginina.domain.repository

import com.beginina.domain.entity.TelegramUser

interface AuthRepository {
    suspend fun login(user: TelegramUser)
}