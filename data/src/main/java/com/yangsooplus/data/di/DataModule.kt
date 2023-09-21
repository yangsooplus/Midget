package com.yangsooplus.data.di

import com.yangsooplus.data.MemoRepository
import com.yangsooplus.data.MemoRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Singleton
    @Binds
    fun bindMemoRepository(
        memoRepositoryImpl: MemoRepositoryImpl,
    ): MemoRepository
}
