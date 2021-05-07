package com.example.qrscanner.domain.usecase

import com.example.qrscanner.domain.model.QrModel
import com.example.qrscanner.domain.repository.LocalRepository
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

class GetQrListUseCase @Inject constructor(private val localRepository: LocalRepository) {


     fun getList(): Flow<List<QrModel>> = localRepository.getAllQrCode()


}