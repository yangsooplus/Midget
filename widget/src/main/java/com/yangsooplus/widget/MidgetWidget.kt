package com.yangsooplus.widget

import MidgetConstants
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import androidx.compose.runtime.Composable
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.action.clickable
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.layout.Box
import androidx.glance.layout.fillMaxSize
import androidx.glance.text.Text

class MidgetWidget : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            MemoContent(
                onClick = {
                    context.startActivity(
                        Intent().apply {
                            component = ComponentName(
                                "com.yangsooplus.midget",
                                "com.yangsooplus.midget.ui.MainActivity",
                            )
                            flags = FLAG_ACTIVITY_NEW_TASK
                            putExtra(MidgetConstants.WIDGET_DESTINATION, "custom")
                        },
                    )
                },
            )
        }
    }

    @Composable
    private fun MemoContent(
        onClick: () -> Unit,
    ) {
        Box(
            modifier = GlanceModifier.fillMaxSize().clickable { onClick() },
        ) {
            Text(text = "hello midget")
        }
    }
}
