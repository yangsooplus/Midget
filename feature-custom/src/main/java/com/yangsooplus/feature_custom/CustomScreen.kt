package com.yangsooplus.feature_custom // ktlint-disable package-name

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.yangsooplus.feature_custom.component.ColorPickerButton
import com.yangsooplus.feature_custom.component.ColorPickerDialog
import com.yangsooplus.feature_custom.component.ShapeButton
import com.yangsooplus.feature_custom.component.StepAdjuster
import com.yangsooplus.ui.component.SegmentedButton
import com.yangsooplus.ui.model.Shape

@Composable
fun CustomScreen(
    viewModel: CustomViewModel = hiltViewModel(),
) {
    val textFieldScrollState = rememberScrollState()
    val decorationScrollState = rememberScrollState()
    val uiState by viewModel.uiState.collectAsState()
    val memoDecoState by viewModel.memoDecoState.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            SelectionContainer(
                modifier = Modifier.fillMaxWidth().weight(2f).padding(16.dp),
            ) {
                Box(
                    modifier = Modifier.background(
                        color = memoDecoState.backgroundDecoration.backgroundColor,
                        shape = when (memoDecoState.backgroundDecoration.backgroundShape) {
                            Shape.Rectangle -> RectangleShape
                            Shape.Circle -> CircleShape
                            Shape.RoundedCorner -> RoundedCornerShape(memoDecoState.backgroundDecoration.backgroundShapeUnit)
                            Shape.CutCorner -> CutCornerShape(memoDecoState.backgroundDecoration.backgroundShapeUnit)
                        },
                    ).border(
                        width = memoDecoState.borderDecoration.borderWidth.dp,
                        color = memoDecoState.borderDecoration.borderColor,
                        shape = when (memoDecoState.borderDecoration.borderShape) {
                            Shape.Rectangle -> RectangleShape
                            Shape.Circle -> CircleShape
                            Shape.RoundedCorner -> RoundedCornerShape(memoDecoState.borderDecoration.borderShapeUnit)
                            Shape.CutCorner -> CutCornerShape(memoDecoState.borderDecoration.borderShapeUnit)
                        },
                    ).padding(24.dp),
                    contentAlignment = memoDecoState.textDecoration.textVerticalAlign,
                ) {
                    Text(
                        text = uiState.memoContent,
                        color = memoDecoState.textDecoration.fontColor,
                        fontSize = memoDecoState.textDecoration.fontSize.sp,
                        fontFamily = memoDecoState.textDecoration.fontFamily,
                        fontWeight = memoDecoState.textDecoration.fontWeight.weight,
                        textAlign = memoDecoState.textDecoration.textAlign,
                        fontStyle = memoDecoState.textDecoration.fontStyle,
                    )
                }
            }
            BasicTextField(
                value = uiState.memoContent,
                onValueChange = { viewModel.updateMemoContent(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(16.dp)
                    .verticalScroll(textFieldScrollState),
                decorationBox = { textField ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                color = MaterialTheme.colorScheme.surface,
                                shape = RoundedCornerShape(12.dp),
                            )
                            .padding(16.dp),
                    ) {
                        textField()
                    }
                },
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f)
                    .padding(24.dp)
                    .verticalScroll(decorationScrollState),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(text = "Text")
                Row(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.Center,
                    ) {
                        ColorPickerButton(
                            color = memoDecoState.textDecoration.fontColor,
                        ) {
                            viewModel.startPickingColor(ColorOption.TextColor)
                        }
                    }
                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.Center,
                    ) {
                        StepAdjuster(
                            onIncrease = { viewModel.adjustFontSize(Adjustment.Up) },
                            onDecrease = { viewModel.adjustFontSize(Adjustment.Down) },
                        ) {
                            Text(text = memoDecoState.textDecoration.fontSize.toString())
                        }
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                ) {
                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.Center,
                    ) {
                        SegmentedButton(
                            items = listOf(
                                FontStyle.Normal to Icons.Default.FavoriteBorder,
                                FontStyle.Italic to Icons.Default.Favorite,
                            ),
                            onItemSelect = { fontStyle ->
                                viewModel.setFontStyle(fontStyle)
                            },
                        )
                    }
                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.Center,
                    ) {
                        StepAdjuster(
                            contentWidth = 80.dp,
                            onIncrease = { viewModel.adjustFontWeight(Adjustment.Up) },
                            onDecrease = { viewModel.adjustFontWeight(Adjustment.Down) },
                        ) {
                            Text(
                                text = memoDecoState.textDecoration.fontWeight.weightName,
                                fontWeight = memoDecoState.textDecoration.fontWeight.weight,
                            )
                        }
                    }
                }
                SegmentedButton(
                    items = listOf(
                        FontFamily.SansSerif to Icons.Filled.FavoriteBorder,
                        FontFamily.Serif to Icons.Filled.FavoriteBorder,
                        FontFamily.Monospace to Icons.Filled.FavoriteBorder,
                        FontFamily.Cursive to Icons.Filled.FavoriteBorder,
                    ),
                    onItemSelect = {
                        viewModel.setFontFamily(it)
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                ) {
                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.Center,
                    ) {
                        SegmentedButton(
                            items = listOf(
                                TextAlign.Start to Icons.Filled.FavoriteBorder,
                                TextAlign.Center to Icons.Filled.Favorite,
                                TextAlign.End to Icons.Filled.Star,
                            ),
                            onItemSelect = { viewModel.setTextAlign(it) },
                        )
                    }
                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.Center,
                    ) {
                        SegmentedButton(
                            items = listOf(
                                Alignment.TopCenter to Icons.Filled.FavoriteBorder,
                                Alignment.Center to Icons.Filled.Favorite,
                                Alignment.BottomCenter to Icons.Filled.Star,
                            ),
                            onItemSelect = { viewModel.setTextVerticalAlign(it) },
                        )
                    }
                }
                Spacer(modifier = Modifier.height(4.dp))
                Divider()
                Text(text = "Background")
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    ColorPickerButton(color = memoDecoState.backgroundDecoration.backgroundColor) {
                        viewModel.startPickingColor(ColorOption.BackgroundColor)
                    }

                    ShapeButton(
                        shape = when (memoDecoState.backgroundDecoration.backgroundShape) {
                            Shape.Rectangle -> RectangleShape
                            Shape.Circle -> CircleShape
                            Shape.RoundedCorner -> RoundedCornerShape(memoDecoState.backgroundDecoration.backgroundShapeUnit)
                            Shape.CutCorner -> CutCornerShape(memoDecoState.backgroundDecoration.backgroundShapeUnit)
                        },
                        fillColor = memoDecoState.backgroundDecoration.backgroundColor,
                    ) {
                        viewModel.changeBackgroundShape()
                    }

                    StepAdjuster(
                        onIncrease = { viewModel.adjustBackgroundShapeUnit(Adjustment.Up) },
                        onDecrease = { viewModel.adjustBackgroundShapeUnit(Adjustment.Down) },
                    ) {
                        Text(text = memoDecoState.backgroundDecoration.backgroundShapeUnit.toString())
                    }
                }
                Spacer(modifier = Modifier.height(4.dp))
                Divider()
                Text(text = "Border")
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.Center,
                    ) {
                        ColorPickerButton(color = memoDecoState.borderDecoration.borderColor) {
                            viewModel.startPickingColor(ColorOption.BorderColor)
                        }
                    }
                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.Center,
                    ) {
                        StepAdjuster(
                            onIncrease = { viewModel.adjustBorderWidth(Adjustment.Up) },
                            onDecrease = { viewModel.adjustBorderWidth(Adjustment.Down) },
                        ) {
                            Text(text = memoDecoState.borderDecoration.borderWidth.toString())
                        }
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.Center,
                    ) {
                        ShapeButton(
                            shape = when (memoDecoState.borderDecoration.borderShape) {
                                Shape.Rectangle -> RectangleShape
                                Shape.Circle -> CircleShape
                                Shape.RoundedCorner -> RoundedCornerShape(memoDecoState.borderDecoration.borderShapeUnit)
                                Shape.CutCorner -> CutCornerShape(memoDecoState.borderDecoration.borderShapeUnit)
                            },
                            borderColor = memoDecoState.borderDecoration.borderColor,
                        ) {
                            viewModel.changeBorderShape()
                        }
                    }
                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.Center,
                    ) {
                        StepAdjuster(
                            onIncrease = { viewModel.adjustBorderShapeUnit(Adjustment.Up) },
                            onDecrease = { viewModel.adjustBorderShapeUnit(Adjustment.Down) },
                        ) {
                            Text(text = memoDecoState.borderDecoration.borderShapeUnit.toString())
                        }
                    }
                }
            }
        }
        uiState.currentColorOption?.let { option ->
            val initialColor = when (option) {
                ColorOption.TextColor -> memoDecoState.textDecoration.fontColor
                ColorOption.BackgroundColor -> memoDecoState.backgroundDecoration.backgroundColor
                ColorOption.BorderColor -> memoDecoState.borderDecoration.borderColor
            }
            val onDismiss: (Color) -> Unit = when (option) {
                ColorOption.TextColor -> { color -> viewModel.setFontColor(color) }
                ColorOption.BackgroundColor -> { color -> viewModel.setBackgroundColor(color) }
                ColorOption.BorderColor -> { color -> viewModel.setBorderColor(color) }
            }
            ColorPickerDialog(initialColor = initialColor, onDismiss = onDismiss)
        }
    }
}

@Preview()
@Composable
fun CustomScreenPreview() {
    Surface(
        Modifier
            .fillMaxSize()
            .background(color = Color.White),
    ) {
        CustomScreen()
    }
}
