package com.yangsooplus.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.yangsooplus.database.model.History
import com.yangsooplus.database.model.Memo
import com.yangsooplus.database.model.MemoWithHistory
import kotlinx.coroutines.flow.Flow

@Dao
interface MemoDao {

    @Transaction
    @Query("SELECT * FROM memo")
    fun getMemos(): Flow<List<MemoWithHistory>>

    @Transaction
    @Query("SELECT * FROM memo WHERE memoId = :memoId")
    fun getMemoByID(memoId: Long): Flow<MemoWithHistory>

    @Insert
    suspend fun insertMemo(memo: Memo)

    @Delete
    suspend fun deleteMemo(memo: Memo)

    @Insert
    suspend fun insertHistory(history: History)

    @Delete
    suspend fun deleteHistory(history: History)
}
