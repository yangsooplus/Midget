package com.yangsooplus.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.yangsooplus.database.model.Memo
import com.yangsooplus.model.Decoration
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(AndroidJUnit4::class)
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

        memoDao.getMemos().collect {
            assertEquals(it.size, 1)
            println(it[0])
        }
    }
}
