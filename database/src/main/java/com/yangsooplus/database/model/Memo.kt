package com.yangsooplus.database.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.yangsooplus.model.Decoration

@Entity(tableName = "memo")
data class Memo(
    @PrimaryKey val memoId: Long,
    val decoration: Decoration,
)

data class MemoWithHistory(
    @Embedded val memo: Memo,
    @Relation(parentColumn = "memoId", entityColumn = "ownerMemoId")
    val histories: List<History>,
)
