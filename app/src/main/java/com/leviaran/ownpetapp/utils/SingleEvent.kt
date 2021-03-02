package com.leviaran.ownpetapp.utils

open class SingleEvent<out T>(private val value : T) {
    var isHandled = false
    private set // Allow external read but not write

    fun getContentIfNotHandled() : T? {
        return if(isHandled) {
            null
        } else {
            isHandled = true
            value
        }
    }

    fun peekContent() : T = value

}