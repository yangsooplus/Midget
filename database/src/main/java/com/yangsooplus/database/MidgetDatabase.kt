package com.yangsooplus.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.yangsooplus.database.model.MemoWithHistory

@Database(entities = [MemoWithHistory::class], version = 1)
@TypeConverters(LocalDateTimeConverter::class)
abstract class MidgetDatabase : RoomDatabase() {
    abstract fun memoDao(): MemoDao
}
