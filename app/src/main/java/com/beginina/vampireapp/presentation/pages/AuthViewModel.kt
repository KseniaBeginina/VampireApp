package com.beginina.vampireapp.presentation.pages

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beginina.domain.entity.TelegramUser
import com.beginina.domain.usecases.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
): ViewModel() {

    fun login(user: TelegramUser){
        viewModelScope.launch {
            try {
                Log.d("AuthViewModel", "Logging in user: $user")
                loginUseCase(user)
            } catch (e: Exception) {
                Log.e("AuthViewModel", "Login failed", e)
            }
        }
    }
}