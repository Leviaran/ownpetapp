package com.leviaran.ownpetapp.usecase

import com.leviaran.ownpetapp.data.error.Error

interface ErrorUseCase {
    fun getError(errorCode: Int) : Error
}