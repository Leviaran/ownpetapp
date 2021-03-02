package com.leviaran.ownpetapp.data.error.mapper

interface ErrorMapper {
    fun getError(errorId: Int): String
    val errorMap: Map<Int, String>
}