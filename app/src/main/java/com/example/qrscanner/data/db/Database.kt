package com.example.qrscanner.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.qrscanner.data.db.dao.ScannerDao
import com.example.qrscanner.data.db.entity.ScannerItem


@Database(entities = [ScannerItem::class],exportSchema = false,version = 1)
abstract class Database : RoomDatabase() {
    abstract fun dao():ScannerDao

}