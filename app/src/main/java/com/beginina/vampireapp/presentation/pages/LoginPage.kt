package com.beginina.vampireapp.presentation.pages

import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.net.toUri
import com.beginina.vampireapp.ui.theme.Black

@Composable
fun LoginPage(
    authViewModel: AuthViewModel
) {
    val intent = CustomTabsIntent.Builder()
        .setDefaultColorSchemeParams(CustomTabColorSchemeParams.Builder()
            .setToolbarColor(Black.value.toInt())
            .build())
        .setUrlBarHidingEnabled(true)
        .build()

    intent.launchUrl(
        LocalContext.current,
        "https://kseniabeginina.github.io/telegram_auth_vampire/".toUri()
    )
}