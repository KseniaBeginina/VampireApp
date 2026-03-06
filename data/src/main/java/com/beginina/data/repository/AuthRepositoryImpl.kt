package com.beginina.data.repository

import com.beginina.data.mapper.toDto
import com.beginina.data.storages.FirebaseAuthStorage
import com.beginina.data.storages.TelegramAuthApi
import com.beginina.domain.entity.TelegramUser
import com.beginina.domain.repository.AuthRepository

class AuthRepositoryImpl(
    private val firebaseAuthStorage: FirebaseAuthStorage,
    private val telegramAuthApi: TelegramAuthApi
): AuthRepository {
    override suspend fun login(user: TelegramUser) {
        val response = telegramAuthApi.login(user.toDto())

        if (!response.isSuccessful) {
            error("Telegram auth failed")
        }

        val token = response.body()!!.string()
        firebaseAuthStorage.login(token)
    }
}