package com.leviaran.ownpetapp.ui.screencomponent.home

import android.util.Log
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.leviaran.ownpetapp.data.DataRepositorySrc
import com.leviaran.ownpetapp.data.Resources
import com.leviaran.ownpetapp.data.dto.PetsResponse
import com.leviaran.ownpetapp.data.dto.PetsResponseItem
import com.leviaran.ownpetapp.ui.base.BaseViewModel
import com.leviaran.ownpetapp.utils.SingleEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val dataRepo : DataRepositorySrc) : BaseViewModel() {

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val petLiveDataPrivate = MutableLiveData<Resources<PetsResponse>>()
    val petLiveData : LiveData<Resources<PetsResponse>> get() = petLiveDataPrivate

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private val openPetDetailPrivate = MutableLiveData<SingleEvent<PetsResponseItem>>()
    val openPetDetail : LiveData<SingleEvent<PetsResponseItem>> get() = openPetDetailPrivate

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private val showSnackBarPrivate = MutableLiveData<SingleEvent<Any>>()
    val showSnackBar : LiveData<SingleEvent<Any>> get() = showSnackBarPrivate

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private val showToastPrivate = MutableLiveData<SingleEvent<Any>>()
    val showToast : LiveData<SingleEvent<Any>> get() = showToastPrivate

    fun getPet() {
        viewModelScope.launch {
            petLiveDataPrivate.value = Resources.Loading()
            dataRepo.requestPet().collect {
                petLiveDataPrivate.value = it
            }
        }
    }

    fun openPetDetail(pet: PetsResponseItem) {
        openPetDetailPrivate.value = SingleEvent(pet)
    }

    fun showToastMessage(errorCode: Int) {
        val error = errorMan.getError(errorCode)
        showToastPrivate.value = SingleEvent(error.description)
    }

    fun showToastMsg() {

    }

}