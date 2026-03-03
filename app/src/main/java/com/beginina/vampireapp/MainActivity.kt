package com.beginina.vampireapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.beginina.domain.entity.TelegramUser
import com.beginina.vampireapp.navigation.NavGraph
import com.beginina.vampireapp.presentation.pages.AuthViewModel
import com.beginina.vampireapp.ui.theme.VampireAppTheme
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val authViewModel by viewModels<AuthViewModel>()
    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashscreen = installSplashScreen()
        var keepSplashScreen = true
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        splashscreen.setKeepOnScreenCondition { keepSplashScreen }
        lifecycleScope.launch {
            delay(2000)
            keepSplashScreen = false
        }

        handleDeepLink(intent)

        setContent {
            VampireAppTheme {
                val startDestination = mainViewModel.startDestination
                NavGraph(startDestination = startDestination)
            }
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        handleDeepLink(intent)
    }

    private fun handleDeepLink(intent: Intent?) {
        val userJson = intent?.data?.getQueryParameter("user")
        userJson?.let {
            val user = Gson().fromJson(it, TelegramUser::class.java)
            Log.d("Login", "Telegram user: $user")
            lifecycleScope.launch {
                authViewModel.login(user)
            }
        }
    }
}
