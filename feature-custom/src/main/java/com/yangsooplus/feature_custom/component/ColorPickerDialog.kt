package com.yangsooplus.feature_custom.component // ktlint-disable package-name

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.github.skydoves.colorpicker.compose.AlphaSlider
import com.github.skydoves.colorpicker.compose.BrightnessSlider
import com.github.skydoves.colorpicker.compose.HsvColorPicker
import com.github.skydoves.colorpicker.compose.rememberColorPickerController
import com.yangsooplus.ui.extension.toHex
import com.yangsooplus.ui.theme.BlueLightGray

@Composable
fun ColorPickerDialog(
    initialColor: Color,
    modifier: Modifier = Modifier,
    onDismiss: (Color) -> Unit,
) {
    val controller = rememberColorPickerController()
    var selectedColor by remember { mutableStateOf(initialColor) }
    var isPicking by remember { mutableStateOf(false) }

    Dialog(
        onDismissRequest = { onDismiss(selectedColor) },
    ) {
        Card(
            modifier = Modifier.then(modifier).fillMaxWidth().height(540.dp).padding(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.background,
                contentColor = MaterialTheme.colorScheme.onBackground,
            ),
        ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    if (isPicking) {
                        var firstClick = true
                        HsvColorPicker(
                            modifier = Modifier.height(300.dp),
                            controller = controller,
                            onColorChanged = { colorEnvelope ->
                                Log.d("color", colorEnvelope.hexCode)
                                if (firstClick) {
                                    firstClick = false
                                } else {
                                    selectedColor = colorEnvelope.color
                                }
                            },
                            initialColor = selectedColor,
                        )
                        AlphaSlider(
                            modifier = Modifier.fillMaxWidth().height(36.dp),
                            controller = controller,
                            borderColor = BlueLightGray,
                            borderRadius = 6.dp,
                            borderSize = 5.dp,
                        )
                        BrightnessSlider(
                            modifier = Modifier.fillMaxWidth().height(36.dp),
                            controller = controller,
                            borderColor = BlueLightGray,
                            borderRadius = 6.dp,
                            borderSize = 5.dp,
                        )
                    } else {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            ColorPickerButton(color = Color.Black) {
                                selectedColor = Color.Black
                            }
                            ColorPickerButton(color = Color.White) {
                                selectedColor = Color.White
                            }
                            ColorPickerButton(color = Color.Transparent) {
                                selectedColor = Color.Transparent
                            }
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            ColorPickerButton(color = Color(0x90735645)) {
                                selectedColor = Color(0x90735645)
                            }
                            ColorPickerButton(color = Color(0xA0000000)) {
                                selectedColor = Color(0xA0000000)
                            }
                            ColorPickerButton(
                                brush = Brush.horizontalGradient(
                                    colors = listOf(
                                        Color.Red,
                                        Color.Yellow,
                                        Color.Green,
                                        Color.Blue,
                                        Color.Magenta,
                                    ),
                                ),
                            ) {
                                isPicking = true
                            }
                        }
                    }
                    Text(text = "Recent Used")
                    // TODO: Recent Used Colors
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom,
                ) {
                    Box(
                        modifier = Modifier.size(width = 100.dp, height = 50.dp)
                            .background(
                                color = selectedColor,
                                shape = RoundedCornerShape(8.dp),
                            ),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = selectedColor.toHex(),
                            color = if (selectedColor.luminance() > 0.5) Color.Black else Color.White,
                        )
                    }
                    if (isPicking) {
                        Button(onClick = {
                            isPicking = false
                        }) {
                            Text(text = "Select")
                        }
                    } else {
                        Button(onClick = { onDismiss(selectedColor) }) {
                            Text(text = "Confirm")
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ColorPickerDialogPreview() {
    ColorPickerDialog(
        initialColor = Color.Cyan,
        onDismiss = { },
    )
}
