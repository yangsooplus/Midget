package com.yangsooplus.ui.model

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class BorderDecoration(
    val borderColor: Color = Color.Transparent,
    val borderShape: Shape = RoundedCornerShape(0.dp),
    val borderWidth: Dp = 1.dp
)
