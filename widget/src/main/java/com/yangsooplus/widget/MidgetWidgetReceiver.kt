package com.yangsooplus.widget

import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import com.yangsooplus.data.repository.MemoRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.MainScope
import javax.inject.Inject

@AndroidEntryPoint
class MidgetWidgetReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = MidgetWidget()
    private val coroutineScope = MainScope()

    @Inject
    lateinit var memoRepository: MemoRepository
}
