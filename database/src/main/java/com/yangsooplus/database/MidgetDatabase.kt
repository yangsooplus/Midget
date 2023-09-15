package com.yangsooplus.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yangsooplus.database.model.MemoWithHistory

@Database(entities = [MemoWithHistory::class], version = 1)
abstract class MidgetDatabase : RoomDatabase() {
    abstract fun memoDao(): MemoDao
}
