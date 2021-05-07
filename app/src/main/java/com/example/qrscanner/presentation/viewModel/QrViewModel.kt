package com.example.qrscanner.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qrscanner.domain.model.QrModel
import com.example.qrscanner.domain.usecase.InsertQrUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class QrViewModel @Inject constructor(private val insertQrUseCase: InsertQrUseCase) : ViewModel() {


    private var _info :MutableLiveData<QrModel> = MutableLiveData()
    val info : LiveData<QrModel>
        get() = _info

    fun insertQrToDb(qrModel: QrModel){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                insertQrUseCase.insertQrItem(qrModel)
            }
        }
    }

    fun sendScannedQr(qrModel: QrModel){
        _info.value = qrModel
    }

}