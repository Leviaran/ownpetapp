package com.leviaran.ownpetapp.data

sealed class Resources<T>(
    val data : T? = null,
    val errorCode: Int? = null
) {
    class Success<T>(data: T) : Resources<T>(data)
    class Loading<T>(data: T? = null) : Resources<T>(data)
    class Error<T>(errorCode: Int) : Resources<T>(null, errorCode)

    override fun toString(): String {
        return when(this) {
            is Success<*> -> "Success [data=$data]"
            is Loading<T> -> "Loading Process"
            is Error -> "Error cause of $errorCode"
        }
    }
}