package com.yangsooplus.database.converter

import androidx.room.TypeConverter
import com.yangsooplus.model.Decoration
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class DecorateConverter {
    @TypeConverter
    fun fromString(data: String): Decoration {
        return json.decodeFromString(data)
    }

    @TypeConverter
    fun toString(decoration: Decoration): String {
        return json.encodeToString(decoration)
    }

    companion object {
        private val json = Json
    }
}