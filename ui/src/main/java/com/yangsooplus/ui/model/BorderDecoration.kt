package com.yangsooplus.ui.model

import androidx.compose.ui.graphics.Color

data class BorderDecoration(
    val borderColor: Color = Color.Transparent,
    val borderShape: Shape = Shape.Rectangle,
    val borderWidth: Int = 1,
    val borderShapeUnit: Int = 10,
)
