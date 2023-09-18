package com.yangsooplus.database.model

import androidx.room.Embedded
import androidx.room.Relation

data class MemoWithHistory(
    @Embedded val memo: Memo,
    @Relation(parentColumn = "memoId", entityColumn = "ownerMemoId")
    val histories: List<History>
)
