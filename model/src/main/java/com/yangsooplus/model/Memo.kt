package com.yangsooplus.model

data class Memo(
    val memoId: Long = 0L,
    val decoration: Decoration,
    val histories: List<History>
)
