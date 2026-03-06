package com.beginina.vampireapp.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.beginina.vampireapp.presentation.pages.AuthViewModel
import com.beginina.vampireapp.presentation.pages.LoginPage
import com.beginina.vampireapp.presentation.pages.UserPage

@Composable
fun NavGraph(startDestination: String){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        composable(Routes.LOGIN){
            val authViewModel: AuthViewModel = hiltViewModel()
            LoginPage(
                authViewModel = authViewModel,
                navController = navController
            )
        }
        composable(Routes.USER){
            Log.d("NavGraph", "UserPage composable created")
            UserPage()
        }
    }
}