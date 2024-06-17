package com.sixhundredwatts.protrainr.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val LightGray = Color(0xFFfcfcfc)
val MediumGray = Color(0xff9c9c9c)
val DarkGray = Color(0xff141414)

val Teal200 = Color(0xff03DAC5)

val LowPriorityColor = Color(0xFF00C980)
val MediumPriorityColor = Color(0xFFFFC114)
val HighPriorityColor = Color(0xFFFF4646)
val NonePriorityColor = Color(0xFFFFFFFF)
val Purple700 = Color(0xff3700b3)

val ColorScheme.fabBackgroundColor:Color
    @Composable
    get() = if( !isSystemInDarkTheme()) Color.White else Purple700

val ColorScheme.fabPlusColor:Color
    @Composable
    get() = if( !isSystemInDarkTheme()) Color.White else Color.Black

val ColorScheme.toAppBarContentColor:Color
    @Composable
    get() = if( !isSystemInDarkTheme()) Color.Black else LightGray

