package com.yangsooplus.feature_custom.component // ktlint-disable package-name

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yangsooplus.ui.extension.drawCheckBoard

@Composable
fun StepAdjuster(
    onIncrease: () -> Unit,
    onDecrease: () -> Unit,
    modifier: Modifier = Modifier,
    contentWidth: Dp = 60.dp,
    centerComponent: @Composable () -> Unit,
) {
    Row(
        modifier = Modifier.then(modifier).height(40.dp),
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
                contentColor = MaterialTheme.colorScheme.onPrimary,
                containerColor = MaterialTheme.colorScheme.primary,
            ),
            contentPadding = PaddingValues(0.dp),
        ) { Text(text = "-", fontSize = 18.sp) }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(contentWidth)
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
                contentColor = MaterialTheme.colorScheme.onPrimary,
                containerColor = MaterialTheme.colorScheme.primary,
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
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Button(
        modifier = Modifier.then(modifier).size(width = 60.dp, height = 40.dp),
        colors = ButtonDefaults.buttonColors(containerColor = color),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.primary),
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
fun ShapeButton(
    shape: Shape,
    modifier: Modifier = Modifier,
    fillColor: Color = Color.Transparent,
    borderColor: Color = Color.Transparent,
    borderWidth: Dp = 2.dp,
    onClick: () -> Unit,
) {
    Button(
        modifier = Modifier.then(modifier).size(width = 60.dp, height = 40.dp),
        colors = ButtonDefaults.buttonColors(containerColor = fillColor),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.primary),
        contentPadding = PaddingValues(),
        onClick = onClick,
    ) {
        Box {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .drawCheckBoard(),
                color = Color.Transparent,
            ) {}
            Surface(
                modifier = Modifier.fillMaxSize().padding(4.dp),
                color = fillColor,
                shape = shape,
                border = BorderStroke(width = borderWidth, color = borderColor),
            ) {}
        }
    }
}

@Preview
@Composable
fun ShapeButtonPreview() {
    Column {
        ShapeButton(
            shape = RoundedCornerShape(10.dp),
            borderColor = Color.Cyan,
            borderWidth = 3.dp,
            onClick = {},
        )
        ShapeButton(shape = RoundedCornerShape(40.dp), fillColor = Color.Magenta, onClick = {})
        ShapeButton(
            shape = CutCornerShape(30.dp),
            fillColor = Color(0xA00000FF),
            borderColor = Color.White,
            onClick = {},
        )
    }
}
