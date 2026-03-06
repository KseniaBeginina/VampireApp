package com.beginina.vampireapp.presentation.components.buttons

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.beginina.vampireapp.ui.theme.Red
import com.beginina.vampireapp.ui.theme.RedTr50
import com.beginina.vampireapp.ui.theme.White
import com.beginina.vampireapp.ui.theme.regular16


@Composable
fun FilledButton(
    text: String,
    backgroundColor: Color = RedTr50,
    borderColor: Color = Red,
    textColor: Color = White,
    onClick: () -> Unit
){
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = textColor
        ),
        modifier = Modifier
            .height(40.dp)
            .border(1.dp, borderColor, RoundedCornerShape(8.dp))
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        onClick = { onClick() }
    ){
        Text(
            text = text,
            style = regular16
        )
    }
}