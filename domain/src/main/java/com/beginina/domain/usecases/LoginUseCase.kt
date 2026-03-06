package com.beginina.domain.usecases

import com.beginina.domain.entity.TelegramUser
import com.beginina.domain.repository.AuthRepository

class LoginUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(user: TelegramUser) = authRepository.login(user)
}