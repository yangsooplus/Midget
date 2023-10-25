package com.yangsooplus.midget.ui

import MidgetConstants
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.yangsooplus.ui.theme.MidgetTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val destination = intent.extras?.getString(MidgetConstants.WIDGET_DESTINATION) ?: "home"
        val appWidgetId = intent.extras?.getInt(MidgetConstants.APPWIDGET_ID)

        setContent {
            MidgetTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Navigation(destination, appWidgetId)
                }
            }
        }
    }
}
