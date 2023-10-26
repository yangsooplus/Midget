package com.yangsooplus.feature_home.select

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yangsooplus.data.repository.MemoRepository
import com.yangsooplus.model.Memo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class SelectViewModel @Inject constructor(
    private val memoRepository: MemoRepository,
) : ViewModel() {

    val memos: StateFlow<List<Memo>> =
        memoRepository.getMemos().stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

    fun selectMemo(memoId: Long, appWidgetId: Int) {

    }
}
