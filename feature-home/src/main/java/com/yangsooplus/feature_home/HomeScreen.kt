package com.yangsooplus.feature_home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.yangsooplus.model.Memo

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onClick: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth().weight(1f),
        ) {
            items(
                items = viewModel.memos.value,
                key = { memo -> memo.memoId },
            ) {
                MemoItem(memo = it)
            }
        }
        Button(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(4.dp),
            onClick = onClick,
        ) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "add memo")
            Text(text = "New Memo")
        }
    }
}

@Composable
fun MemoItem(memo: Memo, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxWidth()
            .background(color = Color.Transparent, shape = RoundedCornerShape(10.dp)),
    ) {
        Text(
            text = memo.histories.last().content,
            modifier = Modifier.align(Alignment.Center).padding(16.dp),
        )
    }
}
