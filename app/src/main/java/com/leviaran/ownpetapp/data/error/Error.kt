package com.leviaran.ownpetapp.data.error

class Error(val code: Int, val description: String) {
    constructor(exception: Exception) : this(code = DEFAULT_ERROR, description = exception.message
        ?: "")
}

const val NO_INTERNET_CONNECTION = -1
const val NETWORK_ERROR = -2
const val DEFAULT_ERROR = -3
const val PASS_WORD_ERROR = -201
const val USER_NAME_ERROR = -202
const val CHECK_YOUR_FIELDS = -203
const val SEARCH_ERROR = -204