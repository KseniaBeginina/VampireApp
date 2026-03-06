package com.beginina.vampireapp.presentation.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.beginina.vampireapp.ui.theme.Black
import com.beginina.vampireapp.ui.theme.White

@Composable
fun UserPage(

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
            .padding(16.dp),
    ){
        Text(text = "hello popa", color = White)
    }
}