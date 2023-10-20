package com.yangsooplus.data

import com.yangsooplus.database.MemoDao
import com.yangsooplus.database.model.toModel
import com.yangsooplus.model.History
import com.yangsooplus.model.Memo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

interface MemoRepository {
    fun getMemos(): Flow<List<Memo>>
    fun getMemoById(memoId: Long): Flow<Memo>
    suspend fun addMemo(memo: Memo): Long
    suspend fun addHistory(memoId: Long, history: History): Long
    suspend fun deleteMemo(memo: Memo)
    suspend fun deleteHistory(history: History)
}

class MemoRepositoryImpl @Inject constructor(
    private val memoDao: MemoDao,
) : MemoRepository {
    override fun getMemos(): Flow<List<Memo>> = memoDao.getMemos().transform { mwh ->
        mwh.map { it.toModel() }
    }

    override fun getMemoById(memoId: Long): Flow<Memo> =
        memoDao.getMemoByID(memoId = memoId).transform { it.toModel() }

    override suspend fun addMemo(memo: Memo) = memoDao.insertMemo(memo = memo.toEntity())

    override suspend fun addHistory(memoId: Long, history: History) =
        memoDao.insertHistory(history = history.toEntity(memoId))

    override suspend fun deleteMemo(memo: Memo) {
        memoDao.deleteMemoById(memoId = memo.memoId)
    }

    override suspend fun deleteHistory(history: History) {
        memoDao.deleteHistoryById(historyId = history.historyId)
    }
}
