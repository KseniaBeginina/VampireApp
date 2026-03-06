package com.beginina.vampireapp.presentation.pages

import android.util.Log
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.net.toUri
import androidx.navigation.NavController
import com.beginina.vampireapp.navigation.Routes
import com.beginina.vampireapp.ui.theme.Black

@Composable
fun LoginPage(
    authViewModel: AuthViewModel,
    navController: NavController
) {
    val context = LocalContext.current
    val isLoggedIn by authViewModel.isLoggedIn.collectAsState()

    LaunchedEffect(Unit) {
    val intent = CustomTabsIntent.Builder()
        .setDefaultColorSchemeParams(CustomTabColorSchemeParams.Builder()
            .setToolbarColor(Black.value.toInt())
            .build())
        .setUrlBarHidingEnabled(true)
        .build()

        intent.launchUrl(
            context,
            "https://kseniabeginina.github.io/telegram_auth_vampire/".toUri()
        )
    }

    LaunchedEffect(isLoggedIn) {
        Log.d("LoginPage", "LaunchedEffect triggered, isLoggedIn=$isLoggedIn")
        if (isLoggedIn){
            navController.navigate(Routes.USER){
                popUpTo(Routes.LOGIN) { inclusive = true }
            }
            Log.d("LoginPage", "Navigated to USER page")
        }
    }
}