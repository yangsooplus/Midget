package com.yangsooplus.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.yangsooplus.database.model.MemoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MemoDao {

    @Insert
    suspend fun insertMemo(memoEntity: MemoEntity)

    @Update
    suspend fun updateMemo(memoEntity: MemoEntity)

    @Delete
    suspend fun deleteMemoById(memoEntity: MemoEntity)

    @Query("SELECT * FROM memo")
    fun getAllMemos(): Flow<List<MemoEntity>>

    @Query("SELECT * FROM memo WHERE id IN (:id)")
    fun getMemoById(id: Int): Flow<MemoEntity>

}
