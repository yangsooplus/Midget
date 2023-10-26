package com.yangsooplus.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "widget")
data class WidgetData(
    val memoId: Long,
    @PrimaryKey val appWidgetId: Int,
)

fun WidgetData.toModel(): com.yangsooplus.model.WidgetData {
    return com.yangsooplus.model.WidgetData(
        memoId = memoId,
        appWidgetId = appWidgetId,
    )
}
