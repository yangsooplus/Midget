package com.yangsooplus.ui.extension

import androidx.compose.ui.graphics.Color

fun Color.toHex(): String {
    return String.format(
        "#%02X%02X%02X%02X",
        (alpha * 255).toInt(),
        (red * 255).toInt(),
        (green * 255).toInt(),
        (blue * 255).toInt(),
    )
}
