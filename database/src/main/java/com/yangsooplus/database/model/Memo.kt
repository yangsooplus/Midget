package com.yangsooplus.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.yangsooplus.database.converter.DecorateConverter
import com.yangsooplus.model.Decoration

@Entity(tableName = "memo")
@TypeConverters(DecorateConverter::class)
data class Memo(
    @PrimaryKey(autoGenerate = true) val memoId: Long = 0,
    val decoration: Decoration,
)
