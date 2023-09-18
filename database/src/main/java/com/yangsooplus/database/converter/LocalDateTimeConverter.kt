package com.yangsooplus.database.converter

import androidx.room.TypeConverter
import java.time.LocalDateTime

class LocalDateTimeConverter {
    @TypeConverter
    fun fromString(stamp: String): LocalDateTime {
        return LocalDateTime.parse(stamp)
    }

    @TypeConverter
    fun toString(localDateTime: LocalDateTime): String {
        return localDateTime.toString()
    }
}