package com.leviaran.ownpetapp.ui.base

import androidx.lifecycle.ViewModel
import com.leviaran.ownpetapp.usecase.ErrorManager
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {
    @Inject
    lateinit var errorMan : ErrorManager
}