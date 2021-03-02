package com.leviaran.ownpetapp.data.error.mapper

import android.content.Context
import com.leviaran.ownpetapp.R
import com.leviaran.ownpetapp.data.error.*
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ErrorMapperImp @Inject constructor (@ApplicationContext val context: Context) : ErrorMapper {
    override fun getError(errorId: Int): String {
        return context.getString(errorId)
    }

    override val errorMap: Map<Int, String>
        get() = mapOf(
            Pair(NO_INTERNET_CONNECTION, getError(R.string.no_internet)),
            Pair(NETWORK_ERROR, getError(R.string.network_error)),
        ).withDefault { getError(R.string.network_error) }

}