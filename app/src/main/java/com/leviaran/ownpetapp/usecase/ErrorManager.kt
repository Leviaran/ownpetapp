package com.leviaran.ownpetapp.usecase

import com.leviaran.ownpetapp.data.error.Error
import com.leviaran.ownpetapp.data.error.mapper.ErrorMapper
import com.leviaran.ownpetapp.data.error.mapper.ErrorMapperImp
import javax.inject.Inject

class ErrorManager @Inject constructor(private val errorMapper : ErrorMapperImp) : ErrorUseCase {
    override fun getError(errorCode: Int): Error {
        return Error(errorCode,errorMapper.errorMap.getValue(errorCode))
    }

}