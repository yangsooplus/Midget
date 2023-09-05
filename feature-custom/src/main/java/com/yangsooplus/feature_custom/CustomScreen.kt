package com.yangsooplus.feature_custom // ktlint-disable package-name

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yangsooplus.feature_custom.component.ColorPickerButton
import com.yangsooplus.feature_custom.component.StepAdjuster
import com.yangsooplus.ui.component.SegmentedButton

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
                text = "memoContent",
                modifier = Modifier.fillMaxWidth().weight(1f).padding(16.dp),
                style = TextStyle(
                    shadow = Shadow(
                        color = Color.Magenta,
                        offset = Offset(3f, -3f),
                        blurRadius = 20f,
                    ),
                ),
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
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(text = "Text")
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
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
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                SegmentedButton(
                    items = listOf(
                        FontStyle.Normal to Icons.Default.FavoriteBorder,
                        FontStyle.Italic to Icons.Default.Favorite,
                    ),
                    onItemSelect = {
                        it
                    },
                )
                StepAdjuster(
                    onIncrease = { /*TODO*/ },
                    onDecrease = { /*TODO*/ },
                ) {
                    Text(text = "Bold")
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                SegmentedButton(
                    items = listOf(
                        TextAlign.Start to Icons.Filled.FavoriteBorder,
                        TextAlign.Center to Icons.Filled.Favorite,
                        TextAlign.End to Icons.Filled.Star,
                    ),
                    onItemSelect = {},
                )
                SegmentedButton(
                    items = listOf(
                        Alignment.Top to Icons.Filled.FavoriteBorder,
                        Alignment.Center to Icons.Filled.Favorite,
                        Alignment.Bottom to Icons.Filled.Star,
                    ),
                    onItemSelect = {},
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(30.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(text = "shadow")
                ColorPickerButton(color = Color.Green) {
                }
                StepAdjuster(
                    onIncrease = { /*TODO*/ },
                    onDecrease = { /*TODO*/ },
                ) {
                    Text(text = "3")
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Spacer(modifier = Modifier.width(80.dp))
                IconButton(
                    onClick = { /*TODO*/ },
                    colors = IconButtonDefaults.iconButtonColors(containerColor = MaterialTheme.colorScheme.primary),
                ) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowLeft,
                        tint = MaterialTheme.colorScheme.onPrimary,
                        contentDescription = null,
                    )
                }
                IconButton(
                    onClick = { /*TODO*/ },
                    colors = IconButtonDefaults.iconButtonColors(containerColor = MaterialTheme.colorScheme.primary),
                ) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowRight,
                        tint = MaterialTheme.colorScheme.onPrimary,
                        contentDescription = null,
                    )
                }
                IconButton(
                    onClick = { /*TODO*/ },
                    colors = IconButtonDefaults.iconButtonColors(containerColor = MaterialTheme.colorScheme.primary),
                ) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowUp,
                        tint = MaterialTheme.colorScheme.onPrimary,
                        contentDescription = null,
                    )
                }
                IconButton(
                    onClick = { /*TODO*/ },
                    colors = IconButtonDefaults.iconButtonColors(containerColor = MaterialTheme.colorScheme.primary),
                ) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowDown,
                        tint = MaterialTheme.colorScheme.onPrimary,
                        contentDescription = null,
                    )
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
