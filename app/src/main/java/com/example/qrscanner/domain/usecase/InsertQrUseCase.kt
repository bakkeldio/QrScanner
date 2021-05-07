package com.example.qrscanner.domain.usecase

import com.example.qrscanner.domain.model.QrModel
import com.example.qrscanner.domain.repository.LocalRepository
import javax.inject.Inject

class InsertQrUseCase @Inject constructor(private val localRepository: LocalRepository) {

    fun insertQrItem(qrModel: QrModel){
        localRepository.insertQrItem(qrModel)
    }
}