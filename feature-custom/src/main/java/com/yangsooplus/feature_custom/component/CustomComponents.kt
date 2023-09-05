package com.yangsooplus.feature_custom.component // ktlint-disable package-name

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.github.skydoves.colorpicker.compose.AlphaSlider
import com.github.skydoves.colorpicker.compose.BrightnessSlider
import com.github.skydoves.colorpicker.compose.HsvColorPicker
import com.github.skydoves.colorpicker.compose.rememberColorPickerController
import com.yangsooplus.ui.extension.drawCheckBoard
import com.yangsooplus.ui.extension.toHex
import com.yangsooplus.ui.theme.BlueLightGray

@Composable
fun StepAdjuster(
    onIncrease: () -> Unit,
    onDecrease: () -> Unit,
    centerComponent: @Composable () -> Unit,
) {
    Row(
        modifier = Modifier.height(40.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Button(
            modifier = Modifier.width(40.dp),
            onClick = onDecrease,
            shape = RoundedCornerShape(
                topStart = 12.dp,
                topEnd = 0.dp,
                bottomStart = 12.dp,
                bottomEnd = 0.dp,
            ),
            colors = ButtonDefaults.buttonColors(
                contentColor = MaterialTheme.colorScheme.onSurface,
                containerColor = MaterialTheme.colorScheme.surface,
            ),
            contentPadding = PaddingValues(0.dp),
        ) { Text(text = "-", fontSize = 18.sp) }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .background(color = Color.White)
                .padding(horizontal = 8.dp),
            contentAlignment = Alignment.Center,
        ) {
            centerComponent()
        }
        Button(
            modifier = Modifier.width(40.dp),
            onClick = onIncrease,
            shape = RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 12.dp,
                bottomStart = 0.dp,
                bottomEnd = 12.dp,
            ),
            colors = ButtonDefaults.buttonColors(
                contentColor = MaterialTheme.colorScheme.onSurface,
                containerColor = MaterialTheme.colorScheme.surface,
            ),
            contentPadding = PaddingValues(0.dp),
        ) { Text(text = "+", fontSize = 18.sp) }
    }
}

@Preview
@Composable
fun StepAdjusterPreview() {
    StepAdjuster(onIncrease = { }, onDecrease = { }) {
        Text(text = "10")
    }
}

@Composable
fun ColorPickerButton(
    color: Color,
    onClick: () -> Unit,
) {
    Button(
        modifier = Modifier.size(width = 60.dp, height = 40.dp),
        colors = ButtonDefaults.buttonColors(containerColor = color),
        shape = RoundedCornerShape(8.dp),
        contentPadding = PaddingValues(),
        onClick = onClick,
    ) {
        if (color.alpha < 1f) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .drawCheckBoard(),
                color = color,
            ) {}
        }
    }
}

@Preview
@Composable
fun ColorPickerButtonPreview() {
    Column {
        ColorPickerButton(color = Color.Transparent, onClick = {})
        ColorPickerButton(color = Color.Magenta, onClick = {})
        ColorPickerButton(color = Color(0xA00000FF), onClick = {})
    }
}

@Composable
fun ColorPickerDialog(
    initialColor: Color,
    onDismiss: (Color) -> Unit,
) {
    val controller = rememberColorPickerController()
    var selectedColor by remember { mutableStateOf(initialColor) }

    Dialog(
        onDismissRequest = { onDismiss(selectedColor) },
    ) {
        Card(
            modifier = Modifier.fillMaxWidth().padding(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.background,
                contentColor = MaterialTheme.colorScheme.onBackground,
            ),
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                HsvColorPicker(
                    modifier = Modifier.height(300.dp),
                    controller = controller,
                    onColorChanged = { colorEnvelope ->
                        selectedColor = colorEnvelope.color
                    },
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
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Box(
                        modifier = Modifier.size(width = 100.dp, height = 50.dp)
                            .background(color = selectedColor, shape = RoundedCornerShape(8.dp)),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = selectedColor.toHex(),
                            color = if (selectedColor.luminance() > 0.5) Color.Black else Color.White,
                        )
                    }
                    Button(onClick = { onDismiss(selectedColor) }) {
                        Text(text = "Confirm")
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
