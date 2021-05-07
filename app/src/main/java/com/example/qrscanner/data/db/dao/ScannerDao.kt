package com.example.qrscanner.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.qrscanner.data.db.entity.ScannerItem
import kotlinx.coroutines.flow.Flow


@Dao
interface ScannerDao {

    @Insert
    fun insertScannerItem(scannerItem: ScannerItem)


    @Query("Select * from qr_code")
    fun getAllCodes(): Flow<List<ScannerItem>>



}