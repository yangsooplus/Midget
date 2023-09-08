package com.yangsooplus.ui.model

import androidx.compose.ui.graphics.Color

data class BackgroundDecoration(
    val backgroundColor: Color = Color.Transparent,
    val backgroundShape: Shape = Shape.Rectangle,
    val backgroundShapeUnit: Int = 10
)
