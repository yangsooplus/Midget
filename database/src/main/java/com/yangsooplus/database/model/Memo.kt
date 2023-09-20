package com.yangsooplus.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.yangsooplus.database.converter.DecorateConverter
import kotlinx.serialization.Serializable

@Entity(tableName = "memo")
@TypeConverters(DecorateConverter::class)
data class Memo(
    @PrimaryKey(autoGenerate = true) val memoId: Long = 0,
    val decoration: Decoration,
)

@Serializable
data class Decoration(
    val fontSize: Int = 16,
    val fontFamily: String = "SansSerif",
    val fontColor: ULong = 0xFF000000UL,
    val fontStyle: String = "Normal",
    val fontWeight: String = "Normal",
    val textAlign: String = "Start",
    val textVerticalAlign: String = "Center",
    val backgroundColor: ULong = 0x00000000UL,
    val backgroundShapeOrdinal: Int = 0,
    val backgroundShapeUnit: Int = 10,
    val borderColor: ULong = 0x00000000UL,
    val borderShapeOrdinal: Int = 0,
    val borderWidth: Int = 1,
    val borderShapeUnit: Int = 10,
)