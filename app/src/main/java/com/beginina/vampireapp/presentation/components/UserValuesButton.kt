package com.beginina.vampireapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beginina.vampireapp.R
import com.beginina.vampireapp.ui.theme.White
import com.beginina.vampireapp.ui.theme.semibold16
import com.beginina.vampireapp.ui.theme.semibold24


@Composable
fun UserValuesButton(
    text: String,
    value: Double,
    icon: Int = R.drawable.ic_launcher_foreground,
    textColor: Color = White,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row (
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ){
            Image(
                modifier = Modifier.size(24.dp),
                painter = painterResource(icon),
                contentDescription = null
            )
            Text(
                text = value.toString(),
                style = semibold24,
                color = textColor
            )
        }
        Text(
            text = text.uppercase(),
            style = semibold16,
            color = textColor
        )
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFF0F0F0F)
fun CheckUserValueButton(){
    UserValuesButton(
        text = "Баллы",
        value = 12.6,
    ){}
}