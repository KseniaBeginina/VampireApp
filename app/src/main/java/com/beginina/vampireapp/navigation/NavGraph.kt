package com.beginina.vampireapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.beginina.vampireapp.presentation.pages.AuthViewModel
import com.beginina.vampireapp.presentation.pages.LoginPage

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
                authViewModel = authViewModel)
        }
    }
}