package com.example.qrscanner.data.db.repository

import com.example.qrscanner.data.db.dao.ScannerDao
import com.example.qrscanner.data.mapper.toDomainModel
import com.example.qrscanner.data.mapper.toEntityModel
import com.example.qrscanner.domain.model.QrModel
import com.example.qrscanner.domain.repository.LocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(private val scannerDao: ScannerDao) :
    LocalRepository {

    override fun insertQrItem(qrModel: QrModel) {
        scannerDao.insertScannerItem(qrModel.toEntityModel())
    }

    override fun getAllQrCode(): Flow<List<QrModel>> = flow {
        scannerDao.getAllCodes().collect { list ->

            emit(list.map {
                it.toDomainModel()
            }
            )
        }
    }


}