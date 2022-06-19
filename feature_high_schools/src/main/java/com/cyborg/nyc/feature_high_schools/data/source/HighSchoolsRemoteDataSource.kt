package com.cyborg.nyc.feature_high_schools.data.source

import com.cyborg.nyc.core.network.RemoteDataSource
import com.cyborg.nyc.core.vo.Result
import com.cyborg.nyc.feature_high_schools.data.HighSchoolsService
import com.cyborg.nyc.feature_high_schools.data.response.HighSchoolDto
import kotlinx.coroutines.CoroutineDispatcher

class HighSchoolsRemoteDataSource(
  private val highSchoolsService: HighSchoolsService,
) : RemoteDataSource() {

  suspend fun getHighSchools(dispatcher: CoroutineDispatcher, zip: String): Result<List<HighSchoolDto>> =
    safeApiCall(dispatcher) { highSchoolsService.getHighSchools(zip) }
}
