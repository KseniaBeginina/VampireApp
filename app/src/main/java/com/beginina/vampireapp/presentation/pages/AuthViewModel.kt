package com.beginina.vampireapp.presentation.pages

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beginina.domain.entity.TelegramUser
import com.beginina.domain.usecases.LoginUseCase
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val firebaseAuth: FirebaseAuth
): ViewModel() {

    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn

    init {
        _isLoggedIn.value = firebaseAuth.currentUser != null
    }

    fun login(user: TelegramUser){
        viewModelScope.launch {
            try {
                Log.d("AuthViewModel", "Logging in user: $user")
                loginUseCase(user)
                _isLoggedIn.value = true
            } catch (e: Exception) {
                Log.e("AuthViewModel", "Login failed", e)
            }
        }
    }
}