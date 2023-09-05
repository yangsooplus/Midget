package com.yangsooplus.feature_custom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomScreen() {
    var memoContent by remember { mutableStateOf("") }
    val textFieldScrollState = rememberScrollState()
    val decorationScrollState = rememberScrollState()

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        BasicTextField(
            value = memoContent,
            onValueChange = { memoContent = it },
            modifier = Modifier.weight(1f).padding(16.dp).verticalScroll(textFieldScrollState),
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
            modifier = Modifier.weight(1f).verticalScroll(decorationScrollState),
        ) {
        }
    }
}
