package com.yangsooplus.ui.model

import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

data class TextDecoration(
    val fontSize: TextUnit = 16.sp,
    val fontFamily: FontFamily = FontFamily.Default,
    val fontColor: Color = Color.Black,
    val fontStyle: FontStyle = FontStyle.Normal,
    val fontWeight: FontWeights = FontWeights.Normal,
    val textAlign: TextAlign = TextAlign.Start,
    val textVerticalAlign: Alignment = Alignment.Center
)
