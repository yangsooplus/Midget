package com.yangsooplus.feature_custom // ktlint-disable package-name

import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yangsooplus.data.repository.MemoRepository
import com.yangsooplus.model.History
import com.yangsooplus.model.Memo
import com.yangsooplus.ui.model.FontWeights
import com.yangsooplus.ui.model.MemoDecoration
import com.yangsooplus.ui.model.Shape
import com.yangsooplus.ui.model.toModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class CustomViewModel @Inject constructor(
    private val memoRepository: MemoRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow(CustomUiState())
    val uiState = _uiState.asStateFlow()

    private val _memoDecoState = MutableStateFlow(MemoDecoration())
    val memoDecoState = _memoDecoState.asStateFlow()

    fun saveMemo() {
        viewModelScope.launch {
            val memoId = memoRepository.addMemo(
                Memo(
                    decoration = _memoDecoState.value.toModel(),
                    histories = emptyList(),
                ),
            )
            memoRepository.addHistory(
                memoId = memoId,
                history = History(
                    content = _uiState.value.memoContent,
                    writeAt = LocalDateTime.now(),
                ),
            )
        }
    }

    fun startPickingColor(option: ColorOption) {
        _uiState.update { it.copy(currentColorOption = option) }
    }

    fun updateMemoContent(memoContent: String) {
        _uiState.update { it.copy(memoContent = memoContent) }
    }

    fun adjustFontSize(adjustment: Adjustment) {
        _memoDecoState.update {
            when (adjustment) {
                Adjustment.Up -> it.copy(fontSize = it.fontSize + 1)
                Adjustment.Down -> it.copy(fontSize = it.fontSize - 1)
            }
        }
    }

    fun adjustFontWeight(adjustment: Adjustment) {
        _memoDecoState.update {
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
        _memoDecoState.update { it.copy(fontFamily = fontFamily) }
    }

    fun setFontColor(color: Color) {
        _memoDecoState.update { it.copy(fontColor = color) }
        _uiState.update { it.copy(currentColorOption = null) }
    }

    fun setFontStyle(fontStyle: FontStyle) {
        _memoDecoState.update { it.copy(fontStyle = fontStyle) }
    }

    fun setTextAlign(textAlign: TextAlign) {
        _memoDecoState.update { it.copy(textAlign = textAlign) }
    }

    fun setTextVerticalAlign(alignment: Alignment) {
        _memoDecoState.update { it.copy(textVerticalAlign = alignment) }
    }

    fun setBackgroundColor(color: Color) {
        _memoDecoState.update { it.copy(backgroundColor = color) }
        _uiState.update { it.copy(currentColorOption = null) }
    }

    fun changeBackgroundShape() {
        val currentShape = _memoDecoState.value.backgroundShape.ordinal
        _memoDecoState.update { it.copy(backgroundShape = Shape.values()[(currentShape + 1) % Shape.values().size]) }
    }

    fun adjustBackgroundShapeUnit(adjustment: Adjustment) {
        _memoDecoState.update {
            it.copy(
                backgroundShapeUnit = when (adjustment) {
                    Adjustment.Up -> it.backgroundShapeUnit + 1
                    Adjustment.Down -> {
                        if (it.backgroundShapeUnit == 0) return
                        it.backgroundShapeUnit - 1
                    }
                },
            )
        }
    }

    fun setBorderColor(color: Color) {
        _memoDecoState.update { it.copy(borderColor = color) }
        _uiState.update { it.copy(currentColorOption = null) }
    }

    fun changeBorderShape() {
        val currentShape = _memoDecoState.value.borderShape.ordinal
        _memoDecoState.update { it.copy(borderShape = Shape.values()[(currentShape + 1) % Shape.values().size]) }
    }

    fun adjustBorderWidth(adjustment: Adjustment) {
        _memoDecoState.update {
            it.copy(
                borderWidth = when (adjustment) {
                    Adjustment.Up -> it.borderWidth + 1
                    Adjustment.Down -> {
                        if (it.borderWidth == 0) return
                        it.borderWidth - 1
                    }
                },
            )
        }
    }

    fun adjustBorderShapeUnit(adjustment: Adjustment) {
        _memoDecoState.update {
            it.copy(
                borderShapeUnit = when (adjustment) {
                    Adjustment.Up -> it.borderShapeUnit + 1
                    Adjustment.Down -> {
                        if (it.borderShapeUnit == 0) return
                        it.borderShapeUnit - 1
                    }
                },
            )
        }
    }
}
