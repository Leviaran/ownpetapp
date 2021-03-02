package com.leviaran.ownpetapp.data

import com.leviaran.ownpetapp.data.dto.PetsResponse
import com.leviaran.ownpetapp.data.remote.RemoteData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class DataRepositoryImp @Inject constructor(private val remoteData: RemoteData, private val ioDispatcher : CoroutineContext) : DataRepositorySrc {
    override suspend fun requestPet(): Flow<Resources<PetsResponse>> {
        return flow {
            emit(remoteData.requestPet())
        }.flowOn(ioDispatcher)
    }
}