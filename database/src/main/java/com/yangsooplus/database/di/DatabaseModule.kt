package com.yangsooplus.database.di

import android.content.Context
import androidx.room.Room
import com.yangsooplus.database.MemoDao
import com.yangsooplus.database.MidgetDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideMemoDao(database: MidgetDatabase): MemoDao {
        return database.memoDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): MidgetDatabase {
        return Room.databaseBuilder(
            context,
            MidgetDatabase::class.java,
            "MemoDatabase",
        ).build()
    }
}
