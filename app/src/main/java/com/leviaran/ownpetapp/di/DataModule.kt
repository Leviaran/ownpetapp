package com.leviaran.ownpetapp.di

import com.leviaran.ownpetapp.data.DataRepositoryImp
import com.leviaran.ownpetapp.data.DataRepositorySrc
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    @Singleton
    abstract fun provideDataRepo(dataRepo : DataRepositoryImp) : DataRepositorySrc
}