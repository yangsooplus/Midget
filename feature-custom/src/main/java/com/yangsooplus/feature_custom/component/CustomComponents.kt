package com.yangsooplus.feature_custom.component // ktlint-disable package-name

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yangsooplus.ui.extension.drawCheckBoard

@Composable
fun StepAdjuster(
    onIncrease: () -> Unit,
    onDecrease: () -> Unit,
    centerComponent: @Composable () -> Unit,
) {
    Row(
        modifier = Modifier.height(40.dp),
    ) {
        Button(
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
        ) { Text(text = "-") }
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
        ) { Text(text = "+") }
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
