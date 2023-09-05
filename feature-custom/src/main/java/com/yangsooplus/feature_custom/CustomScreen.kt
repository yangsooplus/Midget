package com.yangsooplus.feature_custom

import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yangsooplus.feature_custom.component.ColorPickerButton
import com.yangsooplus.feature_custom.component.StepAdjuster

@Composable
fun CustomScreen() {
    var memoContent by remember { mutableStateOf("") }
    val textFieldScrollState = rememberScrollState()
    val decorationScrollState = rememberScrollState()

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        SelectionContainer {
            Text(
                text = memoContent,
                modifier = Modifier.fillMaxWidth().weight(1f).padding(16.dp),
            )
        }
        BasicTextField(
            value = memoContent,
            onValueChange = { memoContent = it },
            modifier = Modifier.fillMaxWidth().weight(1f).padding(16.dp)
                .verticalScroll(textFieldScrollState),
            decorationBox = { textField ->
                Box(
                    modifier = Modifier.fillMaxSize().background(
                        color = MaterialTheme.colorScheme.surface,
                        shape = RoundedCornerShape(12.dp),
                    ).padding(16.dp),
                ) {
                    textField()
                }
            },
        )
        Column(
            modifier = Modifier.fillMaxWidth().weight(1f).padding(24.dp)
                .verticalScroll(decorationScrollState),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = "Text")
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ColorPickerButton(color = Color.Green) {
                }
                StepAdjuster(
                    onIncrease = { /*TODO*/ },
                    onDecrease = { /*TODO*/ },
                ) {
                    Text(text = "14")
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ColorPickerButton(color = Color.Green) {
                }
                StepAdjuster(
                    onIncrease = { /*TODO*/ },
                    onDecrease = { /*TODO*/ },
                ) {
                    Text(text = "Bold")
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ColorPickerButton(color = Color.Green) {
                }
                StepAdjuster(
                    onIncrease = { /*TODO*/ },
                    onDecrease = { /*TODO*/ },
                ) {
                    Text(text = "14")
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ColorPickerButton(color = Color.Green) {
                }
                StepAdjuster(
                    onIncrease = { /*TODO*/ },
                    onDecrease = { /*TODO*/ },
                ) {
                    Text(text = "14")
                }
            }
        }
    }
}

@Preview()
@Composable
fun CustomScreenPreview() {
    Surface(Modifier.fillMaxSize().background(color = Color.White)) {
        CustomScreen()
    }
}
