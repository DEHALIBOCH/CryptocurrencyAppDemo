package com.demoapp.cleanarchdemo.domain.use_cases.get_coin

import com.demoapp.cleanarchdemo.common.Resource
import com.demoapp.cleanarchdemo.data.remote.data_transfer_object.toCoinDetails
import com.demoapp.cleanarchdemo.domain.models.CoinDetails
import com.demoapp.cleanarchdemo.domain.repositories.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetails>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetails()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server"))
        }
    }
}