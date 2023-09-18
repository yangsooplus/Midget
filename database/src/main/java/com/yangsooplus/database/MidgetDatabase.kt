package com.yangsooplus.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yangsooplus.database.model.History
import com.yangsooplus.database.model.Memo

@Database(entities = [Memo::class, History::class], version = 1)
abstract class MidgetDatabase : RoomDatabase() {
    abstract fun memoDao(): MemoDao
}
