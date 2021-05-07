package com.example.qrscanner.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "qr_code")
class ScannerItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val name: String?,
    val email:String?,
    val age:Int?
)