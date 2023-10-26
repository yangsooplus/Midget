package com.yangsooplus.data.di

import com.yangsooplus.data.repository.MemoRepository
import com.yangsooplus.data.repository.MemoRepositoryImpl
import com.yangsooplus.data.repository.WidgetRepository
import com.yangsooplus.data.repository.WidgetRepositoryImpl
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

    @Singleton
    @Binds
    fun bindWidgetRepository(
        widgetRepositoryImpl: WidgetRepositoryImpl,
    ): WidgetRepository
}
