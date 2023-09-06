package com.yangsooplus.ui.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class BackgroundDecoration(
    val backgroundColor: Color = Color.Transparent,
    val backgroundShape: Shape = Shape.Rectangle,
    val backgroundShapeUnit: Dp = 0.dp
)
