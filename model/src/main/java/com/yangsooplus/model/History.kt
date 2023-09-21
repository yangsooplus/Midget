package com.yangsooplus.model

import java.time.LocalDateTime

data class History(
    val historyId: Long = 0,
    val content: String,
    val writeAt: LocalDateTime
)
