package com.yangsooplus.feature_home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yangsooplus.data.MemoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    memoRepository: MemoRepository,
) : ViewModel() {

    val memos =
        memoRepository.getMemos().stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())
}
