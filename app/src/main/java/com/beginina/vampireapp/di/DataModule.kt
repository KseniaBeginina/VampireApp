package com.beginina.chatapp.di

import com.beginina.data.repository.AuthRepositoryImpl
import com.beginina.data.storages.FirebaseAuthStorage
import com.beginina.data.storages.TelegramAuthApi
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideTelegramAuthApi(): TelegramAuthApi {
        return Retrofit.Builder()
            .baseUrl("http://192.168.1.66:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TelegramAuthApi::class.java)
    }
    
    @Provides
    @Singleton
    fun provideFirebaseAuth() = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideFirebaseAuthStorage(firebaseAuth: FirebaseAuth) = FirebaseAuthStorage(firebaseAuth)

    @Provides
    @Singleton
    fun provideAuthRepository(firebaseAuthStorage: FirebaseAuthStorage, telegramAuthApi: TelegramAuthApi) = AuthRepositoryImpl(firebaseAuthStorage, telegramAuthApi)

}