package com.example.qrscanner.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qrscanner.domain.model.QrModel
import com.example.qrscanner.domain.usecase.GetQrListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ListViewModel @Inject constructor(getQrListUseCase: GetQrListUseCase) : ViewModel() {

    private var _list: MutableLiveData<List<QrModel>> = MutableLiveData()
    val list: LiveData<List<QrModel>>
        get() = _list

    init {
        viewModelScope.launch {

            getQrListUseCase.getList().collect {
                _list.value = it
            }
        }

    }
}