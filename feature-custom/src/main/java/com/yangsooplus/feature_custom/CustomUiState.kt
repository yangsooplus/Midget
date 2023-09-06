package com.yangsooplus.feature_custom

data class CustomUiState(
    val currentColorOption: ColorOption? = null,
    val memoContent: String = "",
)

enum class ColorOption {
    TextColor, BackgroundColor, BorderColor
}
