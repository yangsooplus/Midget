package com.yangsooplus.ui.model

import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import com.yangsooplus.model.Decoration

data class MemoDecoration(
    val fontSize: Int = 16,
    val fontFamily: FontFamily = FontFamily.SansSerif,
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

fun MemoDecoration.toModel(): Decoration {
    return Decoration(
        fontSize = fontSize,
        fontFamily = when (fontFamily) {
            FontFamily.SansSerif -> "SansSerif"
            FontFamily.Serif -> "Serif"
            FontFamily.Cursive -> "Cursive"
            FontFamily.Monospace -> "Monospace"
            else -> "Default"
        },
        fontColor = fontColor.value,
        fontStyle = when (fontStyle) {
            FontStyle.Normal -> "Normal"
            FontStyle.Italic -> "Italic"
            else -> "Normal"
        },
        fontWeight = fontWeight.weightName,
        textAlign = when (textAlign) {
            TextAlign.Start -> "Start"
            TextAlign.Center -> "Center"
            TextAlign.End -> "End"
            else -> "Start"
        },
        textVerticalAlign = when (textVerticalAlign) {
            Alignment.Center -> "Center"
            Alignment.TopCenter -> "TopCenter"
            Alignment.BottomCenter -> "BottomCenter"
            else -> "Center"
        },
        backgroundColor = backgroundColor.value,
        backgroundShapeOrdinal = backgroundShape.ordinal,
        backgroundShapeUnit = backgroundShapeUnit,
        borderColor = borderColor.value,
        borderShapeOrdinal = borderShape.ordinal,
        borderWidth = borderWidth,
        borderShapeUnit = borderShapeUnit,
    )
}
