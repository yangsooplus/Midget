package com.yangsooplus.database.model

import androidx.room.Embedded
import androidx.room.Relation

data class MemoWithHistory(
    @Embedded val memo: Memo,
    @Relation(parentColumn = "memoId", entityColumn = "ownerMemoId")
    val histories: List<History>,
)

fun MemoWithHistory.toModel(): com.yangsooplus.model.Memo {
    return com.yangsooplus.model.Memo(
        memoId = memo.memoId,
        decoration = memo.decoration.toModel(),
        histories = histories.map { it.toModel() },
    )
}
