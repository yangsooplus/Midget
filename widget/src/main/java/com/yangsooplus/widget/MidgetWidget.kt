package com.yangsooplus.widget

import MidgetConstants
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import androidx.compose.runtime.Composable
import androidx.datastore.preferences.core.Preferences
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.action.clickable
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetManager
import androidx.glance.appwidget.provideContent
import androidx.glance.currentState
import androidx.glance.layout.Box
import androidx.glance.layout.fillMaxSize
import androidx.glance.text.Text

class MidgetWidget : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        val appWidgetId = GlanceAppWidgetManager(context).getAppWidgetId(id)

        provideContent {
            MemoContent(
                onRegister = {
                    context.startActivity(
                        Intent().apply {
                            component = ComponentName(
                                "com.yangsooplus.midget",
                                "com.yangsooplus.midget.ui.MainActivity",
                            )
                            flags = FLAG_ACTIVITY_NEW_TASK
                            putExtra(MidgetConstants.WIDGET_DESTINATION, "select")
                            putExtra(MidgetConstants.APPWIDGET_ID, appWidgetId)
                        },
                    )
                },
                onClick = {
                    context.startActivity(
                        Intent().apply {
                            component = ComponentName(
                                "com.yangsooplus.midget",
                                "com.yangsooplus.midget.ui.MainActivity",
                            )
                            flags = FLAG_ACTIVITY_NEW_TASK
                            putExtra(MidgetConstants.WIDGET_DESTINATION, "custom")
                            putExtra(MidgetConstants.APPWIDGET_ID, appWidgetId)
                        },
                    )
                },
            )
        }
    }

    @Composable
    private fun MemoContent(
        onClick: () -> Unit,
        onRegister: () -> Unit,
    ) {
        val pref = currentState<Preferences>()

        if (pref[PreferenceKey.memoId] == null) {
            Box(
                modifier = GlanceModifier.fillMaxSize().clickable { onRegister() },
            ) {
                Text(text = "touch to setup")
            }
        } else {
            Box(
                modifier = GlanceModifier.fillMaxSize().clickable { onClick() },
            ) {
                Text(text = "hello midget")
            }
        }
    }
}
