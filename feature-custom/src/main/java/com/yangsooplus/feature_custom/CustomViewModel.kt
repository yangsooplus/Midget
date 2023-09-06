package com.yangsooplus.feature_custom

import androidx.lifecycle.ViewModel
import com.yangsooplus.ui.model.MemoDecoration
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
class CustomViewModel : ViewModel() {
    private val _memoDecoration = MutableStateFlow(MemoDecoration())
    val memoDecoration = _memoDecoration.asStateFlow()
}
