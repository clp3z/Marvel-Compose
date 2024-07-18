package com.clp3z.marvelcompose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.clp3z.marvelcompose.R

val GrandStander = FontFamily(
    Font(R.font.grandstander_black_italic, FontWeight.Black, FontStyle.Italic),
    Font(R.font.grandstander_black, FontWeight.Black, FontStyle.Normal),

    Font(R.font.grandstander_extrabold_italic, FontWeight.ExtraBold, FontStyle.Italic),
    Font(R.font.grandstander_extrabold, FontWeight.ExtraBold, FontStyle.Normal),

    Font(R.font.grandstander_bold_italic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.grandstander_bold, FontWeight.Bold, FontStyle.Normal),

    Font(R.font.grandstander_semibold_italic, FontWeight.SemiBold, FontStyle.Italic),
    Font(R.font.grandstander_semibold, FontWeight.SemiBold, FontStyle.Normal),

    Font(R.font.grandstander_medium_italic, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.grandstander_medium, FontWeight.Medium, FontStyle.Normal),

    Font(R.font.grandstander_regular, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.grandstander_regular, FontWeight.Normal, FontStyle.Normal),

    Font(R.font.grandstander_light_italic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.grandstander_light, FontWeight.Light, FontStyle.Normal),

    Font(R.font.grandstander_extralight_italic, FontWeight.ExtraLight, FontStyle.Italic),
    Font(R.font.grandstander_extralight, FontWeight.ExtraLight, FontStyle.Normal),

    Font(R.font.grandstander_thin_italic, FontWeight.Thin, FontStyle.Italic),
    Font(R.font.grandstander_thin, FontWeight.Thin, FontStyle.Normal),
)

val Typography = Typography(
    body1 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    caption = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    ),
    defaultFontFamily = GrandStander
)