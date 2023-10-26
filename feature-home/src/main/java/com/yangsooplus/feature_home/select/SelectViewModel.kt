package com.yangsooplus.feature_home.select

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yangsooplus.data.repository.MemoRepository
import com.yangsooplus.data.repository.WidgetRepository
import com.yangsooplus.model.Memo
import com.yangsooplus.model.WidgetData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SelectViewModel @Inject constructor(
    private val memoRepository: MemoRepository,
    private val widgetRepository: WidgetRepository,
) : ViewModel() {

    val memos: StateFlow<List<Memo>> =
        memoRepository.getMemos().stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

    fun selectMemo(memoId: Long, appWidgetId: Int) {
        Log.d("widget", "selectMemo $memoId $appWidgetId")
        viewModelScope.launch {
            widgetRepository.addWidgetData(WidgetData(memoId = memoId, appWidgetId = appWidgetId))
        }
    }
}
