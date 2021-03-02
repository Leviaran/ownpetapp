package com.leviaran.ownpetapp.data

import com.leviaran.ownpetapp.data.dto.PetsResponse
import kotlinx.coroutines.flow.Flow

interface DataRepositorySrc {
    suspend fun requestPet() : Flow<Resources<PetsResponse>>
}