package com.yangsooplus.ui.model

import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign

data class MemoDecoration(
    val fontSize: Int = 16,
    val fontFamily: FontFamily = FontFamily.Default,
    val fontColor: Color = Color.Black,
    val fontStyle: FontStyle = FontStyle.Normal,
    val fontWeight: FontWeights = FontWeights.Normal,
    val textAlign: TextAlign = TextAlign.Start,
    val textVerticalAlign: Alignment = Alignment.Center,
    val backgroundColor: Color = Color.Transparent,
    val backgroundShape: Shape = Shape.Rectangle,
    val backgroundShapeUnit: Int = 10,
    val borderColor: Color = Color.Transparent,
    val borderShape: Shape = Shape.Rectangle,
    val borderWidth: Int = 1,
    val borderShapeUnit: Int = 10,
)
