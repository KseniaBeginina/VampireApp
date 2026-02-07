package com.beginina.vampireapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.beginina.vampireapp.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 16.sp,
        lineHeight = 24.sp
    )
)
val preview = TextStyle(
    fontFamily = FontFamily(Font(R.font.augusta_two)),
    fontSize = 16.sp,
    lineHeight = 24.sp
)

val regular16 = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 16.sp,
    lineHeight = 24.sp
)

val semibold16 = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.SemiBold,
    fontSize = 16.sp,
    lineHeight = 24.sp
)

val semibold24 = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.SemiBold,
    fontSize = 24.sp,
    lineHeight = 24.sp
)