package com.yangsooplus.feature_custom

import com.yangsooplus.ui.model.MemoDecoration

data class CustomUiState(
    val currentColorOption: ColorOption? = null,
    val memoContent: String = "",
    val memoDecoration: MemoDecoration = MemoDecoration()
)

enum class ColorOption {
    TextColor, BackgroundColor, BorderColor
}
