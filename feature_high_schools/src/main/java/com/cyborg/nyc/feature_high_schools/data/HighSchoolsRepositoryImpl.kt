package com.cyborg.nyc.feature_high_schools.data

import com.cyborg.nyc.core.dispatcher.DispatcherProvider
import com.cyborg.nyc.core.vo.Result
import com.cyborg.nyc.core.vo.Result.*
import com.cyborg.nyc.feature_high_schools.data.mapper.HighSchoolsMapper
import com.cyborg.nyc.feature_high_schools.data.source.HighSchoolsRemoteDataSource
import com.cyborg.nyc.feature_high_schools.domain.entities.HighSchool
import com.cyborg.nyc.feature_high_schools.domain.repository.HighSchoolsRepository
import javax.inject.Inject

class HighSchoolsRepositoryImpl
@Inject constructor(
  private val dispatcher: DispatcherProvider,
  private val mapper: HighSchoolsMapper,
  private val remoteDataSource: HighSchoolsRemoteDataSource,
) : HighSchoolsRepository {

  override suspend fun getAllHighSchools(zip: String): Result<List<HighSchool>> =
    when (val apiResult = remoteDataSource.getHighSchools(dispatcher.io, zip)) {
      is Loading -> apiResult
      is Success -> Success(mapper.map(apiResult.data))
      is Error -> apiResult
    }
}
