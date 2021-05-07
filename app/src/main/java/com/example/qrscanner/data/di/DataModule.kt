package com.example.qrscanner.data.di

import android.content.Context
import androidx.room.Room
import com.example.qrscanner.data.db.Database
import com.example.qrscanner.data.db.dao.ScannerDao
import com.example.qrscanner.data.db.repository.LocalRepositoryImpl
import com.example.qrscanner.domain.repository.LocalRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class DataModule {


    @Singleton
    @Provides
    fun provideDao(appDatabase: Database):ScannerDao = appDatabase.dao()


    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context):Database{
        return Room.databaseBuilder(context,Database::class.java,"ScannerDB").build()
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule(){

    @Binds
    @Singleton
    abstract fun provideRepo(localRepositoryImpl: LocalRepositoryImpl):LocalRepository
}