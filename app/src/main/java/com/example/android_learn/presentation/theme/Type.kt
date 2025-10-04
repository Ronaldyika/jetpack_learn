package com.example.android_learn.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.example.android_learn.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)


val ubuntufontFamily = FontFamily(
    Font(googleFont = GoogleFont("Ubuntu"), fontProvider = provider)
)


val salsafontFamily = FontFamily(
    Font(googleFont = GoogleFont("Salsa"), fontProvider = provider)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = ubuntufontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = salsafontFamily,
        fontWeight = FontWeight.Thin,
        fontSize = 12.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.5.sp
    ),
    bodySmall = TextStyle(
        fontFamily = ubuntufontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 10.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.4.sp

    )

)