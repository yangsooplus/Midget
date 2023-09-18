package com.yangsooplus.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.yangsooplus.database.converter.LocalDateTimeConverter
import java.time.LocalDateTime

@Entity(tableName = "history")
@TypeConverters(LocalDateTimeConverter::class)
data class History(
    @PrimaryKey(autoGenerate = true) val historyId: Long = 0,
    val ownerMemoId: Long,
    val content: String,
    val writeAt: LocalDateTime,
)
