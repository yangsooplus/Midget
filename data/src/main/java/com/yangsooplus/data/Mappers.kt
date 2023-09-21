package com.yangsooplus.data

import com.yangsooplus.model.Decoration
import com.yangsooplus.model.History
import com.yangsooplus.model.Memo

fun Memo.toEntity(): com.yangsooplus.database.model.Memo {
    return com.yangsooplus.database.model.Memo(
        memoId = memoId,
        decoration = decoration.toEntity(),
    )
}

fun Decoration.toEntity(): com.yangsooplus.database.model.Decoration {
    return com.yangsooplus.database.model.Decoration(
        fontSize = fontSize,
        fontFamily = fontFamily,
        fontColor = fontColor,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        textAlign = textAlign,
        textVerticalAlign = textVerticalAlign,
        backgroundColor = backgroundColor,
        backgroundShapeOrdinal = backgroundShapeOrdinal,
        backgroundShapeUnit = backgroundShapeUnit,
        borderColor = borderColor,
        borderShapeOrdinal = borderShapeOrdinal,
        borderWidth = borderWidth,
        borderShapeUnit = borderShapeUnit,
    )
}

fun History.toEntity(memoId: Long): com.yangsooplus.database.model.History {
    return com.yangsooplus.database.model.History(
        historyId = historyId,
        ownerMemoId = memoId,
        content = content,
        writeAt = writeAt
    )
}