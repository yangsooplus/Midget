package com.yangsooplus.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun <T> SegmentedButton(
    items: List<Pair<T, ImageVector>>,
    modifier: Modifier = Modifier,
    defaultIndex: Int = 0,
    itemWidth: Dp = 50.dp,
    cornerRadius: Dp = 12.dp,
    contentColor: Color = MaterialTheme.colorScheme.primary,
    backgroundColor: Color = MaterialTheme.colorScheme.onPrimary,
    borderWidth: Dp = 0.4.dp,
    onItemSelect: (Int) -> Unit,
) {
    var selectedIndex by remember { mutableIntStateOf(defaultIndex) }

    Row(
        modifier = Modifier.then(modifier),
    ) {
        for (i in items.indices) {
            when (i) {
                0 -> {
                    if (selectedIndex == i) {
                        OutlinedButton(
                            onClick = {
                                onItemSelect(i)
                                selectedIndex = i
                            },
                            modifier = Modifier.width(itemWidth),
                            shape = RoundedCornerShape(
                                topStart = cornerRadius,
                                bottomStart = cornerRadius,
                            ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = contentColor,
                            ),
                            border = BorderStroke(width = borderWidth, color = contentColor),
                            contentPadding = PaddingValues(),
                        ) {
                            Image(
                                imageVector = items[i].second,
                                colorFilter = ColorFilter.tint(backgroundColor),
                                contentDescription = null,
                            )
                        }
                    } else {
                        OutlinedButton(
                            onClick = {
                                onItemSelect(i)
                                selectedIndex = i
                            },
                            modifier = Modifier.width(itemWidth),
                            shape = RoundedCornerShape(
                                topStart = cornerRadius,
                                bottomStart = cornerRadius,
                            ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = backgroundColor,
                            ),
                            border = BorderStroke(width = borderWidth, color = contentColor),
                            contentPadding = PaddingValues(),
                        ) {
                            Image(
                                imageVector = items[i].second,
                                colorFilter = ColorFilter.tint(contentColor),
                                contentDescription = null,
                            )
                        }
                    }
                }

                items.size - 1 -> {
                    if (selectedIndex == i) {
                        OutlinedButton(
                            onClick = {
                                onItemSelect(i)
                                selectedIndex = i
                            },
                            modifier = Modifier.width(itemWidth),
                            shape = RoundedCornerShape(
                                topEnd = cornerRadius,
                                bottomEnd = cornerRadius,
                            ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = contentColor,
                            ),
                            border = BorderStroke(width = borderWidth, color = contentColor),
                            contentPadding = PaddingValues(),
                        ) {
                            Image(
                                imageVector = items[i].second,
                                colorFilter = ColorFilter.tint(backgroundColor),
                                contentDescription = null,
                            )
                        }
                    } else {
                        OutlinedButton(
                            onClick = {
                                onItemSelect(i)
                                selectedIndex = i
                            },
                            modifier = Modifier.width(itemWidth),
                            shape = RoundedCornerShape(
                                topEnd = cornerRadius,
                                bottomEnd = cornerRadius,
                            ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = backgroundColor,
                            ),
                            border = BorderStroke(width = borderWidth, color = contentColor),
                            contentPadding = PaddingValues(),
                        ) {
                            Image(
                                imageVector = items[i].second,
                                colorFilter = ColorFilter.tint(contentColor),
                                contentDescription = null,
                            )
                        }
                    }
                }

                else -> {
                    if (selectedIndex == i) {
                        OutlinedButton(
                            onClick = {
                                onItemSelect(i)
                                selectedIndex = i
                            },
                            modifier = Modifier.width(itemWidth),
                            shape = RoundedCornerShape(0.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = contentColor,
                            ),
                            border = BorderStroke(width = borderWidth, color = contentColor),
                            contentPadding = PaddingValues(),
                        ) {
                            Image(
                                imageVector = items[i].second,
                                colorFilter = ColorFilter.tint(backgroundColor),
                                contentDescription = null,
                            )
                        }
                    } else {
                        OutlinedButton(
                            onClick = {
                                onItemSelect(i)
                                selectedIndex = i
                            },
                            modifier = Modifier.width(itemWidth),
                            shape = RoundedCornerShape(0.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = backgroundColor,
                            ),
                            border = BorderStroke(width = borderWidth, color = contentColor),
                            contentPadding = PaddingValues(),
                        ) {
                            Image(
                                imageVector = items[i].second,
                                colorFilter = ColorFilter.tint(contentColor),
                                contentDescription = null,
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun SegmentedButtonPreview() {
    SegmentedButton(
        items = listOf(
            "favorite" to Icons.Default.Favorite,
            "star" to Icons.Default.Star,
            "send" to Icons.Default.Send,
        ),
        onItemSelect = { },
    )
}
