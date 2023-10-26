package com.yangsooplus.database.model

import androidx.room.Entity

@Entity(tableName = "widget")
data class WidgetData(
    val memoId: Long,
    val appWidgetId: Int,
)

fun WidgetData.toModel(): com.yangsooplus.model.WidgetData {
    return com.yangsooplus.model.WidgetData(
        memoId = memoId,
        appWidgetId = appWidgetId,
    )
}
