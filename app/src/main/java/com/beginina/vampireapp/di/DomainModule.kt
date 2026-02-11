package com.beginina.chatapp.di

import com.beginina.data.repository.AuthRepositoryImpl
import com.beginina.domain.usecases.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {
    @Provides
    fun provideLoginUseCase(authRepository: AuthRepositoryImpl) = LoginUseCase(authRepository)
}