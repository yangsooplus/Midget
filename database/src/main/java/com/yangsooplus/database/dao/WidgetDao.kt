package com.yangsooplus.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.yangsooplus.database.model.WidgetData

@Dao
interface WidgetDao {

    @Insert
    suspend fun insertWidgetData(widgetData: WidgetData)

    @Query("SELECT * FROM widget WHERE appWidgetId = :widgetId")
    fun getWidgetDataByWidgetId(widgetId: Int): WidgetData

    @Query("SELECT * FROM widget WHERE memoId = :memoId")
    fun getWidgetDataByMemoId(memoId: Long): WidgetData
}
