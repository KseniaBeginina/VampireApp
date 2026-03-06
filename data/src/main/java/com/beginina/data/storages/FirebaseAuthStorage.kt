package com.beginina.data.storages

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await

class FirebaseAuthStorage(
    private val firebaseAuth: FirebaseAuth
) {
    suspend fun login(token: String){
        firebaseAuth.signInWithCustomToken(token).await()
        Log.d("FirebaseAuth", "Logged in user: ${firebaseAuth.currentUser?.uid}")
    }
}