package com.yangsooplus.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yangsooplus.database.dao.MemoDao
import com.yangsooplus.database.dao.WidgetDao
import com.yangsooplus.database.model.History
import com.yangsooplus.database.model.Memo
import com.yangsooplus.database.model.WidgetData

@Database(entities = [Memo::class, History::class, WidgetData::class], version = 1)
abstract class MidgetDatabase : RoomDatabase() {
    abstract fun memoDao(): MemoDao
    abstract fun widgetDao(): WidgetDao
}
