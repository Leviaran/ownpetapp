package com.leviaran.ownpetapp.di

import com.leviaran.ownpetapp.data.error.mapper.ErrorMapper
import com.leviaran.ownpetapp.data.error.mapper.ErrorMapperImp
import com.leviaran.ownpetapp.usecase.ErrorManager
import com.leviaran.ownpetapp.usecase.ErrorUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ErrorModule {
    @Binds
    @Singleton
    abstract fun provideErrorFactImp(errorMan: ErrorManager) : ErrorUseCase

    @Binds
    @Singleton
    abstract fun provideErrorMapper(errorMapper: ErrorMapperImp) : ErrorMapper
}