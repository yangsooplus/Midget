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
            MemoContent(context)
        }
    }

    @Composable
    private fun MemoContent(context: Context) {
        Box(
            modifier = GlanceModifier.fillMaxSize().clickable {
                val intent = Intent().apply {
                    component = ComponentName(
                        "com.yangsooplus.midget",
                        "com.yangsooplus.midget.ui.MainActivity",
                    )
                    flags = FLAG_ACTIVITY_NEW_TASK
                    putExtra(MidgetConstants.WIDGET_DESTINATION, "custom")
                }
                context.startActivity(intent)
                /*
                Glance Not Work Issue

                actionStartActivity(
                    componentName = ComponentName(
                        "com.yangsooplus.midget",
                        "com.yangsooplus.midget.ui.MainActivity",
                    ),
                    parameters = actionParametersOf(destinationKey to "home"),
                )
                 */
            },
        ) {
            Text(text = "hello midget")
        }
    }
}
