package com.beworld.shoesapplication.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.beworld.shoesapplication.R

val Raleway = FontFamily(
    Font(R.font.raleway_bold),
    Font(R.font.raleway_light),
    Font(R.font.raleway_medium),
    Font(R.font.raleway_regular),
    Font(R.font.raleway_semi_bold, weight = FontWeight.SemiBold),
    Font(R.font.raleway_thin)
)

val Poppins = FontFamily(
    Font(R.font.poppins_semi_bold),
    Font(R.font.poppins_medium),
    Font(R.font.poppins_regular, weight = FontWeight.W400),
    Font(R.font.poppins_light, weight = FontWeight.Light)
)

val Typography = Typography(
    headlineMedium = TextStyle(
        fontFamily = Raleway,
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp,
    ),
    titleLarge = TextStyle(
        fontFamily = Raleway,
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Light,
        fontSize = 16.sp
    ),
    bodySmall = TextStyle(
        fontFamily = Raleway,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)