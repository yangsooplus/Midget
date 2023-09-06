package com.yangsooplus.ui.model

import androidx.compose.ui.text.font.FontWeight

enum class Shape {
    Rectangle, Circle, RoundedCorner, CutCorner
}

enum class FontWeights(
    val weightName: String,
    val weight: FontWeight,
) {
    Thin("Thin", FontWeight.Thin),
    ExtraLight("ExtraLight", FontWeight.ExtraLight),
    Light("Light", FontWeight.Light),
    Normal("Normal", FontWeight.Normal),
    Medium("Medium", FontWeight.Medium),
    SemiBold("SemiBold", FontWeight.SemiBold),
    Bold("Bold", FontWeight.Bold),
    ExtraBold("ExtraBold", FontWeight.ExtraBold),
    Black("Black", FontWeight.Black),
}
