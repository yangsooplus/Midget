package com.yangsooplus.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "memo")
data class MemoEntity(
    @PrimaryKey val id: Int,
    val history: String,
)
