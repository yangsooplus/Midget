package com.yangsooplus.data.repository

import com.yangsooplus.data.toEntity
import com.yangsooplus.database.dao.WidgetDao
import com.yangsooplus.database.model.toModel
import com.yangsooplus.model.WidgetData
import javax.inject.Inject

interface WidgetRepository {
    suspend fun addWidgetData(widgetData: WidgetData)
    fun getWidgetDataByMemoId(memoId: Long): WidgetData
    fun getWidgetDataByWidgetID(appWidgetId: Int): WidgetData
}

class WidgetRepositoryImpl @Inject constructor(
    private val widgetDao: WidgetDao
): WidgetRepository {
    override suspend fun addWidgetData(widgetData: WidgetData) {
        widgetDao.insertWidgetData(widgetData = widgetData.toEntity())
    }

    override fun getWidgetDataByMemoId(memoId: Long): WidgetData {
        return widgetDao.getWidgetDataByMemoId(memoId).toModel()
    }

    override fun getWidgetDataByWidgetID(appWidgetId: Int): WidgetData {
        return widgetDao.getWidgetDataByWidgetId(appWidgetId).toModel()
    }

}