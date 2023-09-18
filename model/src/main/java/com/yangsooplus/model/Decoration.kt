package com.yangsooplus.model


data class Decoration(
    val fontSize: Int = 16,
    val fontFamily: String = "SansSerif",
    val fontColor: ULong = 0xFF000000UL,
    val fontStyle: String = "Normal",
    val fontWeight: String = "Normal",
    val textAlign: String = "Start",
    val textVerticalAlign: String = "Center",
    val backgroundColor: ULong = 0x00000000UL,
    val backgroundShapeOrdinal: Int = 0,
    val backgroundShapeUnit: Int = 10,
    val borderColor: ULong = 0x00000000UL,
    val borderShapeOrdinal: Int = 0,
    val borderWidth: Int = 1,
    val borderShapeUnit: Int = 10,
)
