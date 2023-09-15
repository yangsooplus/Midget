package com.yangsooplus.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.yangsooplus.database.model.History
import com.yangsooplus.database.model.MemoWithHistory
import kotlinx.coroutines.flow.Flow

@Dao
interface MemoDao {

    @Transaction
    @Query("SELECT * FROM memo")
    fun getMemos(): Flow<List<MemoWithHistory>>

    @Transaction
    @Query("SELECT * FROM history WHERE ownerMemoId = :memoId ORDER BY writeAt DESC")
    fun getHistoryByMemoId(memoId: Long): Flow<List<History>>

    @Insert
    suspend fun insertMemo(memoWithHistory: MemoWithHistory)

    @Delete
    suspend fun deleteMemo(memoWithHistory: MemoWithHistory)

    @Insert
    suspend fun insertHistory(history: History)

    @Delete
    suspend fun deleteHistory(history: History)
}
