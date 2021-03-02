package com.leviaran.ownpetapp.data.remote

import android.util.Log
import com.leviaran.ownpetapp.data.Resources
import com.leviaran.ownpetapp.data.dto.PetsResponse
import com.leviaran.ownpetapp.data.dto.PetsResponseItem
import com.leviaran.ownpetapp.data.error.NETWORK_ERROR
import com.leviaran.ownpetapp.data.error.NO_INTERNET_CONNECTION
import com.leviaran.ownpetapp.data.remote.service.PetServices
import com.leviaran.ownpetapp.utils.NetworkConnectivity
import retrofit2.Response
import javax.inject.Inject

class RemoteData @Inject constructor(private val serviceGenerator: ServiceGenerator, private val networkCon : NetworkConnectivity) : RemoteDataSrc {
    override suspend fun requestPet(): Resources<PetsResponse> {
        val petServ = serviceGenerator.createService(PetServices::class.java)
        val data = petServ.fetchPet("25")
//        return when (val response = call(petServ::fetchPet)) {
        return when (val response = call { data }) {
            is List<*> -> {
                Resources.Success(data = PetsResponse(response as ArrayList<PetsResponseItem>))
            }

            else -> {
                Resources.Error(errorCode = response as Int)
            }
        }
    }

    private suspend fun call(response: suspend () -> Response<*>) : Any? {
        if(!networkCon.isConnected()) {
            return NO_INTERNET_CONNECTION
        }

        return try {
            val response = response.invoke()
            val responseCode = response.code()
            if(response.isSuccessful) {
                response.body()
            } else {
                responseCode
            }
        }catch (ex: Throwable) {
            NETWORK_ERROR
        }
    }

}