package com.yangsooplus.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.yangsooplus.database.model.Decoration
import com.yangsooplus.database.model.History
import com.yangsooplus.database.model.Memo
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.time.LocalDateTime

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(AndroidJUnit4::class)
@SmallTest
class MemoDaoTest {
    private lateinit var database: MidgetDatabase
    private lateinit var memoDao: MemoDao

    @Before
    fun initDatabase() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database =
            Room.inMemoryDatabaseBuilder(context, MidgetDatabase::class.java).build()
        memoDao = database.memoDao()
    }

    @Test
    fun insertAndGetMemo() = runBlocking {
        val memo = Memo(decoration = Decoration())
        memoDao.insertMemo(memo)

        val result = memoDao.getMemos().first()
        assertEquals(result.size, 1)
    }

    @Test
    fun insertHistoryAndGetMemoById() = runBlocking {
        val memo = Memo(decoration = Decoration())
        val content = "memo"
        val memoId = memoDao.insertMemo(memo)

        val history = History(
            ownerMemoId = memoId,
            content = content,
            writeAt = LocalDateTime.now(),
        )

        memoDao.insertHistory(history)

        val result = memoDao.getMemoByID(memoId).first()
        assertEquals(result.histories[0].content, content)
    }

    @Test
    fun deleteMemo() = runBlocking {
        val memo = Memo(decoration = Decoration())
        val memoId = memoDao.insertMemo(memo)
        memoDao.deleteMemoById(memoId)

        val result = memoDao.getMemos().first()
        println(result)
        assertEquals(result.size, 0)
    }

    @Test
    fun deleteHistory() = runBlocking {
        val memo = Memo(decoration = Decoration())
        val memoId = memoDao.insertMemo(memo)
        val history = History(
            ownerMemoId = memoId,
            content = "",
            writeAt = LocalDateTime.now(),
        )
        val historyId = memoDao.insertHistory(history)

        memoDao.deleteHistoryById(historyId)

        val result = memoDao.getMemoByID(memoId).first()
        assertEquals(result.histories.size, 0)
    }
}
