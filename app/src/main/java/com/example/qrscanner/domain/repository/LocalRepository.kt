package com.example.qrscanner.domain.repository

import com.example.qrscanner.domain.model.QrModel
import kotlinx.coroutines.flow.Flow

interface LocalRepository {



    fun insertQrItem(qrModel: QrModel)


    fun getAllQrCode(): Flow<List<QrModel>>
}