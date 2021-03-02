package com.leviaran.ownpetapp.data.remote

import com.leviaran.ownpetapp.data.Resources
import com.leviaran.ownpetapp.data.dto.PetsResponse

internal interface RemoteDataSrc {
    suspend fun requestPet() : Resources<PetsResponse>
}