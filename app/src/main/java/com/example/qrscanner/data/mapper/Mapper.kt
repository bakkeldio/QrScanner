package com.example.qrscanner.data.mapper

import com.example.qrscanner.data.db.entity.ScannerItem
import com.example.qrscanner.domain.model.QrModel


fun ScannerItem.toDomainModel(): QrModel{
    return QrModel(this.id!!,this.age!!,this.name!!, this.email!!)
}
fun QrModel.toEntityModel():ScannerItem{
    return ScannerItem(null,this.name,this.email,this.age)
}