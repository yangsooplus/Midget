package com.yangsooplus.feature_custom // ktlint-disable package-name

import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yangsooplus.ui.model.BackgroundDecoration
import com.yangsooplus.ui.model.BorderDecoration
import com.yangsooplus.ui.model.FontWeights
import com.yangsooplus.ui.model.MemoDecoration
import com.yangsooplus.ui.model.TextDecoration
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CustomViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(CustomUiState())
    val uiState = _uiState.asStateFlow()

    private val _textDecoState = MutableStateFlow(TextDecoration())
    private val _backgroundDecoState = MutableStateFlow(BackgroundDecoration())
    private val _borderDecoState = MutableStateFlow(BorderDecoration())

    val memoDecoState =
        combine(
            _textDecoState,
            _backgroundDecoState,
            _borderDecoState,
        ) { txt, bg, bdr ->
            MemoDecoration(
                textDecoration = txt,
                backgroundDecoration = bg,
                borderDecoration = bdr,
            )
        }.stateIn(viewModelScope, SharingStarted.Eagerly, MemoDecoration())

    fun startPickingColor(option: ColorOption) {
        _uiState.update { it.copy(currentColorOption = option) }
    }

    fun updateMemoContent(memoContent: String) {
        _uiState.update { it.copy(memoContent = memoContent) }
    }

    fun adjustFontSize(adjustment: Adjustment) {
        _textDecoState.update {
            when (adjustment) {
                Adjustment.Up -> it.copy(fontSize = it.fontSize + 1)
                Adjustment.Down -> it.copy(fontSize = it.fontSize - 1)
            }
        }
    }

    fun adjustFontWeight(adjustment: Adjustment) {
        _textDecoState.update {
            val currentWeight = FontWeights.values().indexOf(it.fontWeight)
            val changeWeight = when (adjustment) {
                Adjustment.Up -> {
                    if (currentWeight == FontWeights.values().size - 1) return
                    FontWeights.values()[currentWeight + 1]
                }

                Adjustment.Down -> {
                    if (currentWeight == 0) return
                    FontWeights.values()[currentWeight - 1]
                }
            }
            it.copy(fontWeight = changeWeight)
        }
    }

    fun setFontFamily(fontFamily: FontFamily) {
        _textDecoState.update { it.copy(fontFamily = fontFamily) }
    }

    fun setFontColor(color: Color) {
        _textDecoState.update { it.copy(fontColor = color) }
        _uiState.update { it.copy(currentColorOption = null) }
    }

    fun setFontStyle(fontStyle: FontStyle) {
        _textDecoState.update { it.copy(fontStyle = fontStyle) }
    }

    fun setTextAlign(textAlign: TextAlign) {
        _textDecoState.update { it.copy(textAlign = textAlign) }
    }

    fun setTextVerticalAlign(alignment: Alignment.Vertical) {
        _textDecoState.update { it.copy(textVerticalAlign = alignment) }
    }
}
