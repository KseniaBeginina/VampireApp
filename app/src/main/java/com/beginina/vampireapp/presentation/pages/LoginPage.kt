package com.beginina.vampireapp.presentation.pages

import android.webkit.JavascriptInterface
import android.webkit.WebView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.beginina.domain.entity.TelegramUser
import com.google.gson.Gson

@Composable
fun LoginPage(
    authViewModel: AuthViewModel
) {
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true
                settings.domStorageEnabled = true
                settings.allowFileAccess = true


                addJavascriptInterface(
                    object {
                        @JavascriptInterface
                        fun onAuth(json: String) {
                            val user = Gson()
                                .fromJson(json, TelegramUser::class.java)
                            authViewModel.login(user)
                        }
                    },
                    "TelegramAndroid"
                )

//                loadUrl("file:///android_asset/telegram_login.html")

                val html = context.assets.open("telegram_login.html")
                    .bufferedReader()
                    .use { it.readText() }

                loadDataWithBaseURL(
                    "https://telegram.org",
                    html,
                    "text/html",
                    "UTF-8",
                    null
                )

            }
        }
    )
}