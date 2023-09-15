package com.yangsooplus.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history")
data class History(
    @PrimaryKey val historyId: Long,
    val ownerMemoId: Long,
    val content: String,
    val writeAt: String,
)
