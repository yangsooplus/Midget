package com.yangsooplus.data

import com.yangsooplus.database.MemoDao
import com.yangsooplus.model.History
import com.yangsooplus.model.Memo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface MemoRepository {
    fun getMemos(): Flow<List<Memo>>
    fun getMemoById(memoId: Long): Flow<Memo>
    suspend fun addMemo(memo: Memo)
    suspend fun addHistory(memoId: Long, history: History)
    suspend fun deleteMemo(memo: Memo)
    suspend fun deleteHistory(history: History)
}

class MemoRepositoryImpl @Inject constructor(
    private val memoDao: MemoDao
) : MemoRepository {
    override fun getMemos(): Flow<List<Memo>> {
        TODO("Not yet implemented")
    }

    override fun getMemoById(memoId: Long): Flow<Memo> {
        TODO("Not yet implemented")
    }

    override suspend fun addMemo(memo: Memo) {
        TODO("Not yet implemented")
    }

    override suspend fun addHistory(memoId: Long, history: History) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteMemo(memo: Memo) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteHistory(history: History) {
        TODO("Not yet implemented")
    }
}
