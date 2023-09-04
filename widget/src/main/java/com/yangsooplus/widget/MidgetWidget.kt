package com.yangsooplus.widget

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.layout.Box
import androidx.glance.layout.fillMaxSize
import androidx.glance.text.Text

class MidgetWidget : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            MemoContent()
        }
    }

    @Composable
    private fun MemoContent() {
        Box(
            modifier = GlanceModifier.fillMaxSize(),
        ) {
            Text(text = "hello midget")
        }
    }
}
