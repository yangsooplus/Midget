package com.yangsooplus.ui.extension

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color

fun Modifier.drawCheckBoard(
    tileSize: Float = 8f,
): Modifier {
    return Modifier.then(this).drawBehind {
        val tileCount = (size.width / tileSize).toInt()
        for (i in 0..tileCount) {
            for (j in 0..tileCount) {
                drawRect(
                    topLeft = Offset(i * tileSize, j * tileSize),
                    color = if ((i + j) % 2 == 0) {
                        Color.hsl(0f, 0f, 0.8f)
                    } else {
                        Color.hsl(1f, 1f, 1f)
                    },
                    size = Size(tileSize, tileSize),
                )
            }
        }
    }
}
