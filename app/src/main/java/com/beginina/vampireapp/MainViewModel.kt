package com.beginina.vampireapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.beginina.vampireapp.navigation.Routes
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel(){
    var startDestination by mutableStateOf(Routes.LOGIN)

    init {
        startDestination = if (FirebaseAuth.getInstance().currentUser != null){
            Routes.USER
        } else {
            Routes.LOGIN
        }
    }

}