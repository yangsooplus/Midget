package com.yangsooplus.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yangsooplus.database.model.MemoEntity

@Database(entities = [MemoEntity::class], version = 1)
abstract class MidgetDatabase : RoomDatabase() {
    abstract fun memoDao(): MemoDao
}
