package com.yangsooplus.feature_home.select

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.yangsooplus.feature_home.component.MemoItem
import com.yangsooplus.feature_home.home.HomeViewModel

@Composable
fun SelectScreen(
    appWidgetId: Int,
    viewModel: HomeViewModel = hiltViewModel(),
    onClick: () -> Unit,
) {
    val memos = viewModel.memos.collectAsState().value
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth().weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(
                items = memos,
                key = { memo -> memo.memoId },
            ) {
                MemoItem(memo = it) {
                }
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
