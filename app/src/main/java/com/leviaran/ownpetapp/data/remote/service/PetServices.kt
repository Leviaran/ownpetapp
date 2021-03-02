package com.leviaran.ownpetapp.data.remote.service

import com.leviaran.ownpetapp.data.dto.PetsResponse
import com.leviaran.ownpetapp.data.dto.PetsResponseItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PetServices {
    @GET("v1/breeds")
    suspend fun fetchPet(
        @Query("limit") limit : String
    ) : Response<List<PetsResponseItem>>
}