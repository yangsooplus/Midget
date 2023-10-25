package com.yangsooplus.feature_home.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yangsooplus.model.Memo

@Composable
fun MemoItem(
    memo: Memo,
    modifier: Modifier = Modifier,
    onClick: (Long) -> Unit,
) {
    Box(
        modifier = modifier.fillMaxWidth()
            .border(width = 1.dp, color = MaterialTheme.colorScheme.primary)
            .clickable { onClick(memo.memoId) },
    ) {
        Text(
            text = memo.histories.last().content,
            modifier = Modifier.align(Alignment.Center).padding(16.dp),
        )
    }
}
